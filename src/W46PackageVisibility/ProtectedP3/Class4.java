package W46PackageVisibility.ProtectedP3;
import W46PackageVisibility.ProtectedP1.*;

public class Class4 extends Class1 {
    public static void main(String[] args) {
        Class4 c3 = new Class4();
        System.out.print(c3.num); // works (even though num is protected) because Class4 is subclass of Class1
    }
}

