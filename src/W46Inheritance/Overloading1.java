package W46Inheritance;

class Mammal {
    void makeSound() {
        System.out.println("???");
    }
}

class Cat extends Mammal {
    @Override // you do not "really" need this
    void makeSound() {
        System.out.println("Marrameu");
    }
}

class Human extends Mammal {
    @Override
    void makeSound() {
        super.makeSound();
        System.out.println("Hola!");
    }
}

public class Overriding1 {
    public static void main(String[] args) {
        Mammal mammal = new Mammal();
        Cat cat = new Cat();
        Human human = new Human();

        mammal.makeSound();
        cat.makeSound();
        human.makeSound();
    }
}

