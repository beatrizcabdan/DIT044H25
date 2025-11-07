
import java.util.Scanner;

public class Example6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        while (num != 7) {
            System.out.print("Guess the number: ");

            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
        }

        System.out.println("You guessed it!");

        scanner.close();
    }
}
