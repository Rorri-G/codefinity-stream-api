/*
Varios empleados trabajan en la fábrica, y necesitamos identificar a los tres empleados más trabajadores según la cantidad de horas trabajadas.

Ordenar la lista de workers en orden ascendente por el número de hoursWorked utilizando el método comparingInt().
Invertir la lista de workers para que quede en orden descendente por el número de hoursWorked usando el método reversed().
Seleccionar a los tres trabajadores principales con mayor hoursWorked utilizando el método limit().
Imprimir cada uno de estos tres trabajadores en la consola.
*/
package com.example;

import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Worker> workers = List.of(
                new Worker("John", 160),
                new Worker("Michael", 200),
                new Worker("Andrew", 180),
                new Worker("David", 220),
                new Worker("Robert", 175)
        );

        List<Worker> topWorkers = workers.stream()
                .sorted(Comparator.comparingInt(Worker::getHoursWorked).reversed())
                .limit(3)
                .toList();

        topWorkers.forEach(System.out::println);
    }
}

class Worker {
    private String name;
    private int hoursWorked;

    public Worker(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return "Worker{name='" + name + "', hoursWorked=" + hoursWorked + "}";
    }
}