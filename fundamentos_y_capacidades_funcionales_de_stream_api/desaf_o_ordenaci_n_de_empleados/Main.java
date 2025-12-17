/*
Implementar un Comparator para ordenar la lista de employees según los criterios especificados.

Ordenar los empleados por años de experiencia en orden ascendente, y luego aplicar el método reversed() para que el orden sea descendente.
Si los años de experiencia son iguales, ordenar a los empleados con la misma experiencia por salary en orden descendente.
Si tanto la experiencia como el salario son iguales, ordenar por name en orden alfabético.
Utilizar el comparator creado como argumento para el método sort() para ordenar la lista de empleados.
Imprimir la lista ordenada de empleados.
*/

package com.example;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Michael", 5, 90000, "HR"),
                new Employee("Emily", 3, 65000, "IT"),
                new Employee("James", 5, 95000, "Marketing"),
                new Employee("Sarah", 5, 90000, "IT"),
                new Employee("David", 2, 50000, "Finance")
        ));

        // Comparator: Sort by years of experience (descending), then salary (descending), then name (alphabetical)
        Comparator<Employee> employeeComparator = Comparator
                .comparing(Employee::getYearsOfExperience).reversed()
                .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                .thenComparing(Employee::getName);

        employees.sort(employeeComparator);
        employees.forEach(System.out::println);
    }
}

class Employee {
    private final String name;
    private final int yearsOfExperience;
    private final double salary;
    private final String department;

    public Employee(String name, int yearsOfExperience, double salary, String department) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " | Experience: " + yearsOfExperience + " years | Salary: $" + salary + " | Department: " + department;
    }
}