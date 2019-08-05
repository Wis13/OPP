package com.javalesson.domainmodel;

public class Employee {

    private static int id;
    private int employeeid;
    private String name;
    private String position;
    private int salary;
    private String department;

    public Employee() {
        this("A", "B" ,1);
        System.out.println(toString());
        System.out.println("Construktor with empty called ");
    }

    public Employee(String name, String position, int salary){
        this(name, position, salary, "IT");
        System.out.println("Constructor with 3 params called");
    }

    private Employee(String name, String position, int salary, String department) {
        employeeid = id++;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
        System.out.println("Constructor with 4 params called");
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
