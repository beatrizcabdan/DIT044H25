package W46PackageVisibility.AutonomousVehicles;
import W46PackageVisibility.TraditionalCar.Car;

public class AutonomousCar extends Car {

    public AutonomousCar(String brand, int speed, String model, String engineNumber) {
        super(brand, speed, model, engineNumber);
    }

    public void displayDetails() {
        System.out.println("AutonomousCar:");
        System.out.println("Brand: " + brand); // public
        System.out.println("Speed: " + speed); // protected
        System.out.println();
    }
}

