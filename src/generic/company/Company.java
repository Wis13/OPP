package generic.company;

import generic.company.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public <T extends Employee> void addDepartment(Department<T> dept){
        departments.add(dept);
        List<T> employeeList = dept.getEmployees();
        giveRise(employeeList);
        this.employees.addAll(employeeList);
    }

    private void giveRise(List<?extends Employee> employees){
        for (Employee employee : employees){
            float rise = employee.getSalary() * 0.2f;
            employee.setSalary(employee.getSalary() + rise);
        }
    }

    private void print(List<?> list){
        System.out.println("Size "+ list.size());
        System.out.println(list);
    }

    public List<Department> getDepartments() { return departments; }

    public List<Employee> getEmployees() { return employees; }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                ", employees=" + employees +
                '}';
    }
}
