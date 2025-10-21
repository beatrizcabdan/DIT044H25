package W46PackageVisibility;

import W46PackageVisibility.TraditionalCar.Car;
import W46PackageVisibility.AutonomousVehicles.AutonomousCar;

public class VisibilityTest {

    public static void main(String[] args) {
        // Case 1: accessing via AutonomousCar subclass method
        AutonomousCar autonomous = new AutonomousCar("Tesla", 250, "Model S", "ENG-001");
        autonomous.displayDetails(); // works: protected accessible inside subclass

        // Case 2: accessing via Car’s own method
        Car generic = new Car("Tesla", 250, "Sedan", "ENG-001");
        generic.displayDetails(); // can print everything internally, even private field

        // Case 3: direct access from outside both packages
        System.out.println("Public (brand): " + autonomous.brand); // public, accessible

        // Case 4: try it yourselves!
        // System.out.println("Protected (speed): " + autonomous.speed); // protected, not accessible by object ref outside package
        // System.out.println("Default (model): " + autonomous.model); // default, not accessible outside package
        // System.out.println("Private (engineNumber): " + autonomous.engineNumber); // private, not accessible
    }
}
 