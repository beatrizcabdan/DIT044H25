
import java.util.Scanner;

public class Example4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Enter a number: ");

            if (scanner.hasNextInt()) {
                n = scanner.nextInt();

                if (n < 0) {
                    // print("Stopped!")
                    System.out.println("Stopped!");
                    // break
                    break;
                }

                System.out.println("You entered: " + n);
            } else {
                System.out.println("Invalid input. Try again.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
