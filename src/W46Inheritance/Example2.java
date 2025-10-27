package W46Inheritance;

class Vehicle {
    String plate = "0000XXX";
    public void vehicleSound() {
        System.out.println("The vehicle with plate " + plate +" makes a sound");
    }
}

class Car extends Vehicle {
    public void vehicleSound() {
        super.vehicleSound();
        // using super to access parent method of same name!
        // what would happen if we just write vehicleSound()?
        System.out.println("For cars that is: vroom vroom!");
    }
}

class Motorbike extends Vehicle {
    String plate = "1111XXX";
    public void vehicleSound() {
        System.out.println("The bike with plate " + super.plate + " makes the sound VROOMVROOM VROOOOOOOOOOOOM!");
        // using super to access attribute in parent class
        // what would happen if we just write plate?
    }
}

public class Example2 {
    public static void main(String[] args) {
        Car myCar = new Car();
        Motorbike myBike = new Motorbike();

        myCar.vehicleSound();
        myBike.vehicleSound();
    }
}
