/*
En la tienda, existe una regla: si un producto cuesta más de $1000, debe ser entregado en un plazo de 5 días. Es necesario verificar si esta regla se cumple para todos los productos costosos.

Filtrar la lista de products, conservando solo aquellos con un price mayor que 1000 utilizando el método filter().
Comprobar si todos los productos filtrados tienen un tiempo de entrega de 5 días o menos usando allMatch().
    */

package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Laptop", 1200, 3),
            new Product("Smartphone", 800, 4),
            new Product("TV", 1500, 7)
        );

        boolean isAllHaveFastDelivery = products.stream()
                    .filter(product -> product.getPrice() > 1000)
                    .allMatch(product -> product.getDeliveryDays() <= 5);

        System.out.println("Do all expensive products have fast delivery? " + isAllHaveFastDelivery); 
    }
}

class Product {
    private String name;
    private double price;
    private int deliveryDays;

    public Product(String name, double price, int deliveryDays) {
        this.name = name;
        this.price = price;
        this.deliveryDays = deliveryDays;
    }

    public double getPrice() {
        return price;
    }

    public int getDeliveryDays() {
        return deliveryDays;
    }
}