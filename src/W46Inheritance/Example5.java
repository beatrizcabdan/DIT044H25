package W46Inheritance;

class Class3 {
    final float PI = 3.14f;
}

class Class4 extends Class3 {
    public void changePI() {
        // PI = 10; // cannot assign a value to final variable PI
        System.out.println("Changing PI to " + PI);
    }
}

public class Example5 {
    public static void main(String[] args) {
        Class4 c2 = new Class4();
        c2.changePI();
    }
}

