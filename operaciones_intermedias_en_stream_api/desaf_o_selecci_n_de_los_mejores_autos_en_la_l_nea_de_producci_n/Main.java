/*
En la fábrica, es necesario procesar una lista de autos, filtrarlos según el kilometraje, ordenarlos de acuerdo con criterios específicos y mostrar los resultados.

Cada auto está representado por la clase Car, que contiene un id como identificador único, un model que especifica el nombre del auto, un year que indica el año de fabricación y un campo mileage que representa la distancia total recorrida.

Filtrar los autos, conservando solo aquellos con un kilometraje de 30,000 millas o menos utilizando el método filter().
Ordenar los autos por year en orden ascendente usando el método comparingInt().
Una vez que los autos estén ordenados por year, invertir el orden para que los autos más nuevos aparezcan primero utilizando el método reversed().
Si dos autos tienen el mismo year, ordenarlos por mileage en orden ascendente usando el método thenComparing().
Convertir cada auto en una representación de cadena, utilizando el método toString().
Imprimir la lista final en la consola, usando una referencia al método println().
*/

package com.example;

import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = List.of(
            new Car(1, "Toyota Camry", 2022, 12000),
            new Car(2, "Ford Mustang", 2020, 45000),
            new Car(3, "Tesla Model 3", 2022, 6000),
            new Car(4, "Chevrolet Malibu", 2019, 32000),
            new Car(5, "Honda Accord", 2020, 25000)
        );

        List<String> processedCars = cars.stream()
            .filter(car -> car.getMileage() <= 30000)
            .sorted(Comparator.comparingInt(Car::getYear).reversed()
                .thenComparingInt(Car::getMileage))
            .map(Car::toString)
            .toList();

        processedCars.forEach(System.out::println);
    }
}


class Car {
    private int id;
    private String model;
    private int year;
    private int mileage;

    public Car(int id, String model, int year, int mileage) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return model + " (Year: " + year + ", Mileage: " + mileage + " miles)";
    }
}