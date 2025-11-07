package W46PackageVisibility.ProtectedP2;
import W46PackageVisibility.ProtectedP1.*;

class Class3 {
    public static void main(String args[]) {
        Class1 c1 = new Class1();
        // System.out.println(c1.num); // num has protected access in Class1
    }
}

