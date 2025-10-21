package W46PackageVisibility.AutonomousVehicles;

import W46PackageVisibility.TraditionalCar.Car;

public class AutonomousTruck extends Car {

    public AutonomousTruck(String brand, int speed, String model, String engineNumber) {
        super(brand, speed, model, engineNumber);
    }

    public void displayDetails() {
        System.out.println("AutonomousTruck:");
        System.out.println("Brand: " + brand); // public
        System.out.println("Speed: " + speed); // protected
        System.out.println();
    }
}
