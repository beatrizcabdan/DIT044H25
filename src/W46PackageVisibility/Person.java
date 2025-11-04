package W46PackageVisibility;

public class Person {
    // private variable
    private String name;

    public void setName(String name)  {
        this.name = name; // accessible within class
    }

    public String getName() {
        return name;
    }
}

