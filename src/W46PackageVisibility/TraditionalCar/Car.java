package W46PackageVisibility.TraditionalCar;

public class Car {
    public String brand; // Public, accessible everywhere
    protected int speed; // Protected, accessible in subclasses
    String model; // Default (package-private), same package only
    private String engineNumber; // Private, only inside Car

    // Constructor
    public Car(String brand, int speed, String model, String engineNumber) {
        this.brand = brand;
        this.speed = speed;
        this.model = model;
        this.engineNumber = engineNumber;
    }

    //DO WE WANT THIS GETTER? WHAT DOES IT ALLOW?
    public String getModel() {
        return model;
    }

    //DO WE WANT THIS GETTER? WHAT DOES IT ALLOW?
    public String getEngineNumber() {
        return engineNumber;
    }

    // Public method to show info (can access private field)
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Model: " + model);
        System.out.println("Engine Number: " + engineNumber);
        System.out.println();
    }
}
