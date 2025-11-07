package W46Inheritance;

class Animal {
    int age = 0;
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
}

class Dog extends Animal {
    String name;
}

public class Example1 {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        Pig myPig = new Pig();

        myDog.animalSound();
        myPig.animalSound();
    }
}

