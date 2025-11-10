package W46Inheritance;

class Reptile {
    public void makeSound() {
        System.out.println("Sssssss!");
    }

    public void makeSound(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Sssssss!");
        }
    }
}

class Iguana extends Reptile {
    @Override
    public void makeSound() {
        System.out.println("Fffffff!");
    }
}

public class Overriding2 {
    public static void main(String[] args) {
        Iguana iguana = new Iguana();

        iguana.makeSound();
        iguana.makeSound(3); // this method is not overriden in iguana
    }
}
