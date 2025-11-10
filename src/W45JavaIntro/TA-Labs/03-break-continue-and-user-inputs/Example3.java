
import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type something: ");
        String text = scanner.nextLine();

        System.out.println("You typed: " + text);

        scanner.close();
    }
}
