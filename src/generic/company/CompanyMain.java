package generic.company;

import generic.company.employees.Accountant;
import generic.company.employees.ITSpecialist;
import generic.company.employees.Manager;

public class CompanyMain {
    public static void main(String[] args) {
        Company company = new Company();

        Department<Accountant> accounting = new Department<>("Accounting", 5);
        Department<Manager> management = new Department<>("Management", 2);
        Department<ITSpecialist> itGuys = new Department<>("Managment", 10);

        Accountant accountant = new Accountant("Alex",1000.0f);
        ITSpecialist it = new ITSpecialist("James", 2000.0f);
        Manager manager = new Manager("Michael", 4000.0f);

        accounting.addEmployee(accountant);
        itGuys.addEmployee(it);
        management.addEmployee(manager);

        company.addDepartment(accounting);
        company.addDepartment(itGuys);
        company.addDepartment(management);
        System.out.println(company);
    }
}
