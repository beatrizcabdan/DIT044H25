package W50MVC;

public class Client {
    public static void main(String[] args) {
        View customer1 = new View();
        customer1.showMenu();
        customer1.buyChickenPieces(25);

        View customer2 = new View();
        customer2.showMenu();
    }
}

class Manager extends Client {
    public static void main(String[] args) {
        View manager = new View("Markus");
        manager.showMenu();
        manager.addChickenPieces(7);
        manager.showMenu();
    }
}
