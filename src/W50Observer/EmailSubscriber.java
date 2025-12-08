package W50Observer;

public class EmailSubscriber implements Subscriber {

    @Override
    public void update() {
        System.out.println("Email subscriber updated!");
    }
}
