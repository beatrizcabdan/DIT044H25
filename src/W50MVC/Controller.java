package W50MVC;

public class Controller {
    Model database;
    boolean accessRights;

    public Controller() {
        this.database = Model.getInstance();
        this.accessRights = false;
    }

    public Controller(String name) {
        this.database = Model.getInstance();
        this.accessRights = database.checkResponsible(name);
    }

    public void addChickenPieces(int pieces) {
        if (accessRights) database.chickenPieces += pieces;
    }

    public int checkStock(String element) {
        if (element == "chickenPieces")
            return database.chickenPieces;
        return 0;
    }

    //could throw exception if something is illegal
    public void updateChickenPieces(int piecesBought) {
        if (database.getChickenPieces() > piecesBought)
            database.updateChickenPieces(piecesBought);
        //very not ok: else System.out.println("Sorry it is not possible");
    }
}
