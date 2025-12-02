package W49TAsession;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    private final String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL to " + email + ": " + message);
    }
}

abstract class BaseNotifier implements Notifier {
    protected final Notifier wrappee;

    public BaseNotifier(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

class LadoksNotifier extends BaseNotifier {
    private final String phoneNumber;

    public LadoksNotifier(Notifier wrappee, String phoneNumber) {
        super(wrappee);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS from Ladok to " + phoneNumber + ": " + message);
    }
}

class CanvasNotifier extends BaseNotifier {
    private final String studentAccount;

    public CanvasNotifier(Notifier wrappee, String facebookAccount) {
        super(wrappee);
        this.studentAccount = facebookAccount;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Canvas message to " + studentAccount + ": " + message);
    }
}

class SlackNotifier extends BaseNotifier {
    private final String slackChannel;

    public SlackNotifier(Notifier wrappee, String slackChannel) {
        super(wrappee);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SLACK message to channel " + slackChannel + ": " + message);
    }
}

public class NotifierDemo {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier("gustudent@gu.se");
        notifier = new LadoksNotifier(notifier, "+123456789");
        notifier = new CanvasNotifier(notifier, "student.canvas");
        notifier = new SlackNotifier(notifier, "#course-announcements");
        notifier.send("Mock exam on Thu!");
    }
}
