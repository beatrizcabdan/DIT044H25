package W46Inheritance;

class Animal {
    String name;
    int age;

    void makeSound() {
        System.out.println("soooound");
    }
}

class Cow extends Animal {
    String sound = "mooooo";
}

class Goat extends Animal {
    String sound = "beeeeeeh";
}

public class Example1_class2 {
    public static void main(String[] args) {
        Cow mooMoo = new Cow();
        Goat patricia = new Goat();

        mooMoo.makeSound();
        patricia.makeSound();

        System.out.println(mooMoo.sound);
        System.out.println(patricia.sound);
    }
}

