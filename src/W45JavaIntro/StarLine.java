package W45JavaIntro;
import java.util.Scanner;

public class StarLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        char c = '*';
        for (int i = 0; i < num; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
}
