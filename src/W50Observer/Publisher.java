package W50Observer;

import java.util.ArrayList;
import java.util.Random;

public class Publisher {
    //have a list of subscribers
    public ArrayList<Subscriber> subscribers;
    public int stockedUnits;
    private Random rand;

    //create list and methods for adding to and removing from list
    public Publisher() {
        subscribers = new ArrayList<>();
        stockedUnits = 0;
        rand = new Random();
    }

    void addSubscriber(Subscriber subscriber) {
        System.out.println("Adding subscriber!");
        subscribers.add(subscriber);
    }

    void removeSubscriber(Subscriber subscriber) {
        boolean removed = subscribers.remove(subscriber);
        if (removed) {
            System.out.println("The subscriber has been removed!");
        } else {
            System.out.println("The subscriber was not there to start with!");
        }
    }

    //notify subscribers
    void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    void mainBusinessLogic() {
        int tempStock = stockedUnits;
        stockedUnits = rand.nextInt(5);
        System.out.println("Units: " + stockedUnits);
        if (tempStock != stockedUnits ) {
            notifySubscribers();
        }
    }
}
