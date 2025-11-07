
public class Example8 {

    public static void main(String[] args) {
        int month = 4;

        // another way to write a switch case, using the arrow syntax
        // no need for break here!
        switch (month) {
            case 12, 1, 2 ->
                System.out.println("Winter");
            case 3, 4, 5 ->
                System.out.println("Spring");
            case 6, 7, 8 ->
                System.out.println("Summer");
            default ->
                System.out.println("Autumn");
        }
    }
}
