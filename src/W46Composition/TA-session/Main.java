import company.Company;
import company.Employee;

public class Main {
    public static void main(String[] args) {
        Company chalmers = new Company();

        try {
            Employee ionel = new Employee("Ionel");
            chalmers.addEmployee(ionel);

            Employee razvan = new Employee("Razvan");
            chalmers.addEmployee(razvan);
        } catch (Exception exception) {
            System.out.println("Exception caught: " + exception.getMessage());
        }
    }
}
