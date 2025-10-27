package W45JavaIntro;

public class Example2 {
    public static void main(String[] args) {

        // variables
        int myNum = 5;
        float myFloat = 5.0f;
        char myChar = 'A';
        boolean myBoolean = true;
        String myString = "Hello world!";

        // prints
        System.out.println(myNum);
        System.out.println(myFloat);
        System.out.println(myChar);
        System.out.println(myBoolean);
        System.out.println(myString);

        // don't forget the ()s in Java!
        if (myBoolean) {

            // concatenate strings and ints (in Python it would be myString + " " + str(myNum)
            System.out.println(myString + " x " + String.valueOf(myNum));
        }
    }
}
