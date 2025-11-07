package W46Inheritance;

class Class1 {
    final void display() {
        System.out.println("Display Class 1");
    }
}

class Class2 extends Class1 {
    //Class2 cannot override display() in Class1, we need another
    public void display2() {
        System.out.println("Display Class 2");
    }
}

public class Example4 {
    public static void main(String[] args) {
        Class2 c2 = new Class2();
        c2.display();
        c2.display2();
    }
}

