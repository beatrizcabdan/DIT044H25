package company;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws Exception {
        if ("Ionel".equals(employee.getName())) {
            employees.add(employee);
        } else {
            throw new Exception("The employee name is not Ionel.");
        }
    }
}
