package W50MVC;

import java.util.Random;

// Jollibee (pretend it is a singleton)
public class Model {
    static Model database;
    int chickenPieces;
    String nameOfResponsible = "Mark";

    private Model() {
        Random rand = new Random();
        chickenPieces = rand.nextInt(100);
    }

    public boolean checkResponsible(String name) {
        if (name.equals(nameOfResponsible)) return true;
        return false;
    }

    public static Model getInstance() {
        if (database == null) database = new Model();
        return database;
    }

    public void updateChickenPieces(int piecesBought) {
        chickenPieces = chickenPieces - piecesBought;
    }

    public int getChickenPieces() {
        return chickenPieces;
    }
}
