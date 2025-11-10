
public class Example8 {

    public static void main(String[] args) {
        boolean found = false;
        int i = 0;
        int j = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (i == 1 && j == 2) {
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        System.out.println("Stopped at: " + i + ", " + j);
    }
}
