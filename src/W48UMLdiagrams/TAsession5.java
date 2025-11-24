package W48UMLdiagrams;

import java.util.ArrayList;
import java.util.Random;

interface SlotsMachine {
    int spinOnce();
}

class GameSymbol {
    private String name;
    private int payout;

    public GameSymbol(String name, int payout) {
        this.name = name;
        this.payout = payout;
    }

    public String getName() {
        return name;
    }

    public int getPayout() {
        return payout;
    }

    @Override
    public String toString() {
        return name;
    }
}

class GameReel {
    private ArrayList<GameSymbol> GameSymbols = new ArrayList<>();
    private Random random = new Random();

    public GameReel(ArrayList<GameSymbol> GameSymbols) {
        this.GameSymbols.addAll(GameSymbols);
    }

    public GameSymbol spin() {
        int index = random.nextInt(GameSymbols.size());
        return GameSymbols.get(index);
    }
}

class ClassicSlotMachine implements SlotsMachine {
    private ArrayList<GameReel> reels = new ArrayList<>();

    public ClassicSlotMachine(int numberOfReels, ArrayList<GameSymbol> GameSymbolsForEachReel) {
        for (int i = 0; i < numberOfReels; i++) {
            reels.add(new GameReel(GameSymbolsForEachReel));
        }
    }

    @Override
    public int spinOnce() {
        ArrayList<GameSymbol> result = new ArrayList<>();
        for (GameReel reel : reels) {
            result.add(reel.spin());
        }

        GameSymbol first = result.get(0);
        boolean allMatch = true;
        for (GameSymbol s : result) {
            if (!s.getName().equals(first.getName())) {
                allMatch = false;
                break;
            }
        }

        if (allMatch) {
            return first.getPayout() * reels.size();
        } else {
            return 0;
        }
    }
}

class LowButSureSlotMachine implements SlotsMachine {
    public int spinOnce() {
        return 5;
    }
}


public class TAsession5 {
    public static void main(String[] args) {

        ArrayList<GameSymbol> symbols = new ArrayList<>();
        symbols.add(new GameSymbol("Cherry", 10));
        symbols.add(new GameSymbol("Seven", 50));
        symbols.add(new GameSymbol("Bar", 20));

        SlotsMachine classic = new ClassicSlotMachine(3, symbols);
        SlotsMachine bonus   = new LowButSureSlotMachine();

        System.out.println("Payout: " + classic.spinOnce());
        System.out.println("Payout: " + bonus.spinOnce());
    }
}
