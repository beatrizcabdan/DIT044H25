package W46Inheritance;

class Animal1 {
    void eat() {
        System.out.println("eating");
    }
}

class Dog extends Animal1 {
    String name;
    void eat() {
        System.out.println("eating bones");
    }
}

public class Example1_class {
    public static void main(String[] args) {
        Dog marlin = new Dog();
        marlin.eat();
    }
}
