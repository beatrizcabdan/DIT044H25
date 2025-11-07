
public class Example7 {

    public static void main(String[] args) {
        String day = "Tuesday";
        switch (day) {
            case "Monday":
                System.out.println("Start of work week");
                break;
            case "Friday":
                System.out.println("Almost weekend");
                break;
            case "Saturday", "Sunday":
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Midweek day");
                break;
        }
    }
}
