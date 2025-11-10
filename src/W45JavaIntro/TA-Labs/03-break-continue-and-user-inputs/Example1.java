
public class Example1 {

    public static void main(String[] args) {
        int count = 1;
        // note: in normal programs you don't want to have a while-true loop
        // there are some exceptions, but try not to use while(true)
        while (true) {
            System.out.println(count);
            if (count == 5) {
                break;
            }
            count++;
        }
    }
}
