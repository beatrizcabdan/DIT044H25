package W48UMLdiagrams;

import java.util.ArrayList;
import java.util.Random;

class Symbol {
    private String name;
    private int payout;

    public Symbol(String name, int payout) {
        this.name = name;
        this.payout = payout;
    }

    public String getName() {
        return name;
    }

    public int getPayout() {
        return payout;
    }

    public String toString() {
        return name;
    }
}

class Reel {
    private ArrayList<Symbol> symbols = new ArrayList<>();
    private Random random = new Random();

    public Reel(ArrayList<Symbol> symbols) {
        this.symbols.addAll(symbols);
    }

    public Symbol spin() {
        int index = random.nextInt(symbols.size());
        return symbols.get(index);
    }
}

class SlotMachine {
    private ArrayList<Reel> reels = new ArrayList<>();

    public SlotMachine(int numberOfReels, ArrayList<Symbol> symbolsForEachReel) {
        for (int i = 0; i < numberOfReels; i++) {
            reels.add(new Reel(symbolsForEachReel));
        }
    }

    public int spinOnce() {
        ArrayList<Symbol> result = new ArrayList<>();
        for (Reel reel : reels) {
            result.add(reel.spin());
        }

        Symbol first = result.get(0);
        boolean allMatch = true;
        for (Symbol s : result) {
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
public class TAsession4 {
    public static void main(String[] args) {

        // create some symbols
        Symbol cherry = new Symbol("Cherry", 10);
        Symbol seven = new Symbol("Seven", 50);
        Symbol bar = new Symbol("Bar", 20);

        ArrayList<Symbol> symbols = new ArrayList<>();
        symbols.add(cherry);
        symbols.add(seven);
        symbols.add(bar);

        // slot machine with 3 reels
        SlotMachine machine = new SlotMachine(3, symbols);

        // SPIN!
        for (int i = 1; i <= 5; i++) {
            int payout = machine.spinOnce();
            System.out.println("Spin " + i + ": " + payout + " SEK");
        }
    }
}
