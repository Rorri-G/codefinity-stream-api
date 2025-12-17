/*
La fábrica produce productos representados por objetos Product, que tienen los campos id, weight y quality.

Filtrar los productos para conservar solo aquellos con un quality igual a "GOOD" y un weight mayor que 10.0.
Extraer únicamente el id de los productos filtrados utilizando una referencia a método.
Una vez que el resultado se haya recopilado en una lista, imprimir el id de los productos seleccionados usando una referencia a método a println.
*/
package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product(1, 10.0, "GOOD"),
            new Product(2, 8.2, "DEFECTIVE"),
            new Product(3, 12.3, "GOOD"),
            new Product(4, 10.5, "GOOD"),
            new Product(5, 11.0, "GOOD")
        );

        List<Integer> passingProductIds = products.stream()
            .filter(p -> p.getQuality().equals("GOOD") && p.getWeight() > 10.0)
            .map(Product::getId)
            .toList();

        passingProductIds.forEach(System.out::println);
    }
}

class Product {
    private int id;
    private double weight;
    private String quality;

    public Product(int id, double weight, String quality) {
        this.id = id;
        this.weight = weight;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getQuality() {
        return quality;
    }
}