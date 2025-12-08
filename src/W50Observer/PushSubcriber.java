package W50Observer;

public class PushSubcriber implements Subscriber {

    @Override
    public void update() {
        System.out.println("Push subscriber updated!");
    }
}
