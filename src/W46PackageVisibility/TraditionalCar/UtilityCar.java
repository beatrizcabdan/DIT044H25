package W46PackageVisibility.TraditionalCar;

public class UtilityCar extends Car {

    public UtilityCar(String brand, int speed, String model, String engineNumber) {
        super(brand, speed, model, engineNumber);
    }

    public void displayDetails() {
        System.out.println("UtilityCar:");
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Model: " + model);
        System.out.println();
    }
}
