package com.java.Demo;
//Demostarte the polymorphism Example By using abstract class

abstract class Employee { //Abstract class 
    public abstract double calculateSalary(); //Abstarct Method
}
//The Above Abstract Class Serves As a all Super classes from All Different Employee Types
// Its Is a blueprint of all Employee Classes Which inherit the calculate salary method from the employee class its acts 
// as a polymorphism
class FullTimeEmployee extends Employee {
    private double salary;
    public FullTimeEmployee(double salary) {
        this.salary = salary;
    }
    public double calculateSalary() {
        return salary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    public PartTimeEmployee(double hourlyRate, double hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class ContractEmployee extends Employee {
    private double contractAmount;
    public ContractEmployee(double contractAmount) {
        this.contractAmount = contractAmount;
    }
    public double calculateSalary() {
        return contractAmount;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new FullTimeEmployee(50000);
        employees[1] = new PartTimeEmployee(25, 50);
        employees[2] = new ContractEmployee(12000);
        
        for (Employee employee : employees) {
            System.out.println("Salary: " + employee.calculateSalary());
        }
    }         
}
//This is what makes the program able to handle all types of employees in a consistent and flexible way, 
// without the need to create  separate methods for each employee type.
//abstract class can contain abstract methods (methods without a body) that must be overridden by the subclasses.



