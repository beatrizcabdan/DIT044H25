package W46PackageVisibility;

import W46PackageVisibility.AutonomousVehicles.AutonomousCar;
import W46PackageVisibility.TraditionalCar.Car;
import W46PackageVisibility.TraditionalCar.SportsCar;
import W46PackageVisibility.TraditionalCar.UtilityCar;

public class TestCars {
    public static void main(String[] args) {
        Car generic = new Car("Generic Car", 100, "Sedan", "ENG-001");
        SportsCar sports = new SportsCar("Ferrari", 320, "F8 Tributo", "ENG-002");
        UtilityCar utility = new UtilityCar("Toyota", 120, "Hilux", "ENG-003");
        AutonomousCar autonomous = new AutonomousCar("Tesla", 250, "Model S", "ENG-004");

        generic.displayDetails();
        sports.displayDetails();
        utility.displayDetails();
        autonomous.displayDetails();
    }
}
