package W46PackageVisibility.ProtectedP1;

public class Class2 {
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        System.out.println(c1.num); //works because same package
    }
}

