
import java.util.Scanner;

public class Example5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;

        while (true) {
            System.out.print("Say something: ");
            text = scanner.nextLine();

            if (text.equals("stop")) {
                break;
            }

            System.out.println("You said: " + text);
        }

        scanner.close();
    }
}
