/*
Implementar un sistema de carrito de compras que calcule el costo total del pedido, aplicando un descuento e impuesto sobre las ventas según condiciones predefinidas.

Utilizar map() para obtener el precio total de cada producto (existe un método dedicado getTotalPrice() en la clase Product).
Aplicar reduce() para sumar todos los precios de los productos.
Utilizar un operador ternario para verificar si el subtotal supera el umbral de descuento (DISCOUNT_THRESHOLD) y calcular el discount. Si el subtotal es mayor que el umbral, aplicar un 10% de descuento (DISCOUNT_PERCENTAGE); de lo contrario, establecer el descuento en 0.0.
Determinar el monto del descuento multiplicando el subtotal por DISCOUNT_PERCENTAGE.
Calcular el monto antes de impuestos (preTaxAmount) restando el discount al subtotal.
Calcular el impuesto sobre las ventas (tax) multiplicando el preTaxAmount por la tasa de impuesto sobre las ventas (SALES_TAX).
Devolver el total final, calculado como preTaxAmount + tax.
*/

package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
            new Product("Laptop", 1200.0, 1),
            new Product("Wireless Headphones", 150.0, 2),
            new Product("Smartphone", 800.0, 1),
            new Product("Charging Cable", 25.0, 3),
            new Product("Tablet", 600.0, 1),
            new Product("Mechanical Keyboard", 200.0, 1),
            new Product("Gaming Mouse", 100.0, 1)
        ));

        System.out.println("Subtotal: $" + cart.calculateSubtotal());
        System.out.println("Total (after tax & discount): $" + cart.calculateTotal());
    }
}

class ShoppingCart {
    private List<Product> products;
    private static final double SALES_TAX = 0.08; // 8% sales tax
    private static final double DISCOUNT_THRESHOLD = 1000.0;
    private static final double DISCOUNT_PERCENTAGE = 0.10; // 10% discount

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public double calculateSubtotal() {
        return products.stream()
                .map(Product::getTotalPrice)
                .reduce(0.0, Double::sum);
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double discount = (subtotal > DISCOUNT_THRESHOLD) ? subtotal * DISCOUNT_PERCENTAGE : 0.0;
        double preTaxAmount = subtotal-discount;
        double tax = preTaxAmount * SALES_TAX;
        return preTaxAmount + tax;
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}