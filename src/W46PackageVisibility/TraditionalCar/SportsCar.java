package W46PackageVisibility.TraditionalCar;

public class SportsCar extends Car {

    // Constructor calls parent constructor
    public SportsCar(String brand, int speed, String model, String engineNumber) {
        super(brand, speed, model, engineNumber);
    }

    public void displayDetails() {
        System.out.println("SportsCar:");
        System.out.println("Brand: " + brand); // public
        System.out.println("Speed: " + speed); // protected
        System.out.println("Model: " + model); // default (same package)
        System.out.println();
    }
}
