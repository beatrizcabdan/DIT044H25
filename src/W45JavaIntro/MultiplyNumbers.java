package W45JavaIntro;
import java.util.Scanner;

public class MultiplyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1= scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println(num1*num2);

        scanner.close();
    }
}
