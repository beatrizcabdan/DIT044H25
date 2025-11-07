
import java.util.ArrayList;
import java.util.List;

public class Example5 {

    public static void main(String[] args) {
        // this is how you do it with a list
        // there are also other ways to do this
        // e.g.,
        // String[] fruits = {"apple", "banana", "cherry"};
        // int size = fruits.length;
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        // .size() works for lists
        // .length works for arrays
        // alternatively for(String fruit : fruits), but try not to use it for now
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
    }
}
