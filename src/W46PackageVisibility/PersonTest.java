package W46PackageVisibility;

public class PersonTest {
    static public void main(String[] args) {
        Person person = new Person();
        //System.out.println(person.name); // does not work (name is private)
        System.out.println(person.getName()); // works (getName() is public)
    }
}

