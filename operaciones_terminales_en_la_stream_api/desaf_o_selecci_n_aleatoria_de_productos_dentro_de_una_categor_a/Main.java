/*
Imagina que tienes una lista de productos de una tienda en línea. El objetivo es agruparlos por categoría, seleccionar un producto aleatorio de cada grupo y mostrar el resultado.

Agrupa la lista de productos por category utilizando groupingBy().
Para cada categoría (productList), obtén la lista de productos usando el método stream() y selecciona un producto aleatorio con findAny().
Verifica si el Optional contiene un valor usando ifPresent().
Si el Optional tiene un valor, imprime la información en el siguiente formato: "Category: {category} => {product}".
    */
package com.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product(1, "Laptop", "Electronics", 800),
            new Product(2, "Smartphone", "Electronics", 500),
            new Product(3, "Keyboard", "Computer Accessories", 50),
            new Product(4, "Monitor", "Electronics", 300),
            new Product(5, "Mouse", "Computer Accessories", 30)
        );

        products.stream()
            .collect(Collectors.groupingBy(Product::getCategory)) // Group by category
            .forEach((category, productList) -> {
                Optional<Product> randomProduct = productList.stream().findAny(); // Pick a random product
                randomProduct.ifPresent(product -> 
                    System.out.println("Category: " + category + " => " + product)
                );
            });
    }
}

class Product {
    private final int id;
    private final String name;
    private final String category;
    private final double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}