package W48UMLdiagrams;

import java.sql.SQLOutput;
import java.util.ArrayList;

class Key {
    private String label;

    public Key(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

class Pocket {
    private ArrayList<Key> keys = new ArrayList<>();

    public void addKey(Key key) {
        keys.add(key);
    }

    public ArrayList<Key> getKeys() {
        return keys;
    }
}

class Jacket {
    private ArrayList<Pocket> pockets = new ArrayList<>();

    public Jacket(int numberOfPockets) {
        for (int i = 0; i < numberOfPockets; i++) {
            pockets.add(new Pocket());
        }
    }

    public ArrayList<Pocket> getPockets() {
        return pockets;
    }

    public void addKeyToPocket(int pocketIndex, Key key) {
        if (pocketIndex < 0 || pocketIndex >= pockets.size()) {
            throw new IllegalArgumentException("Invalid pocket index");
        }
        pockets.get(pocketIndex).addKey(key);
    }
}


public class TAsession2 {
    public static void main(String[] args) {
        Jacket jacket = new Jacket(2);
        Key key1 = new Key("Home");
        Key key2 = new Key("Office");
        jacket.addKeyToPocket(0, key1);
        jacket.addKeyToPocket(1, key2);

        for (Pocket pocket : jacket.getPockets()) {
            for (Key key : pocket.getKeys()) {
                System.out.println("In a pocket we have " + key.getLabel() + " keys.");
            }
        }
    }
}
