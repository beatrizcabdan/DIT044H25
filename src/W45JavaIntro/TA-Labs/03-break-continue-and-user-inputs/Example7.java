
import java.util.Scanner;

public class Example7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        int n;

        while (true) {
            System.out.print("Enter a number (0 to quit): ");

            if (scanner.hasNextInt()) {
                n = scanner.nextInt();

                if (n == 0) {
                    break;
                }

                total += n;

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
        }

        System.out.println("Total: " + total);

        scanner.close();
    }
}
