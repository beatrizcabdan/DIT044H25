package W50MVC;

public class View {
    Controller controller;

    public View() {
        controller = new Controller();
    }

    public View(String name) {
        controller = new Controller(name);
    }

    void showMenu() {
        System.out.println("Welcome to Jollibee!");
        System.out.println("We have " + controller.checkStock("chickenPieces") + " pieces of chicken in stock!");
    }

    //could print sorry message if something is not possible//could print sorry message if something is not possible
    public void buyChickenPieces(int piecesBought) {
        controller.updateChickenPieces(piecesBought);
    }

    public void addChickenPieces(int piecesAdded) {
        controller.addChickenPieces(piecesAdded);
    }
}
