package W50Observer;

public class ObserverClient {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new PushSubcriber();
        Subscriber subscriber2 = new PushSubcriber();
        Subscriber subscriber3 = new EmailSubscriber();

        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);
        publisher.addSubscriber(subscriber3);
        publisher.removeSubscriber(subscriber2);

        for (int i = 0; i < 10; i++) {
            publisher.mainBusinessLogic();
        }
    }
}
