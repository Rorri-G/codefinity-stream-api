/*
Implementar un programa que calcule los impuestos según tramos de ingresos, aplicando diferentes tasas impositivas dependiendo del nivel de ingresos.

Si el ingreso es superior a 100,000, la tasa impositiva es del 25%.
Si el ingreso está entre 50,000 y 100,000, la tasa impositiva es del 15%.
Si el ingreso es inferior a 50,000, la tasa impositiva es del 5%.

Establecer los valores apropiados en if y else if para las condiciones de ingreso.
Multiplicar el monto por el porcentaje correspondiente en cada caso para obtener el importe correcto del impuesto.
En el método calculateTaxes, iterar sobre el arreglo de ingresos utilizando un bucle for-each.
Añadir el impuesto de cada ingreso a la lista result utilizando la interfaz funcional taxFunction pasada como parámetro.
Almacenar el resultado del método calculateTaxes en la variable taxes.

*/

package com.example;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // List of incomes
        List<Double> incomes = Arrays.asList(120000.0, 80000.0, 40000.0, 150000.0);

        // Function to calculate tax
        Function<Double, Double> calculateTax = income -> {
    if (income > 100000) {
        return income * 0.25;
    } else if (income >= 50000) {
        return income * 0.15;
    } else {
        return income * 0.05;
    }
        };
    
    
List<Double> taxes = calculateTaxes(incomes, calculateTax);
    }
public static List<Double> calculateTaxes(List<Double> incomes, Function<Double, Double> taxFunction) {
    List<Double> result = new ArrayList<>();
    for (Double income : incomes) {
        result.add(taxFunction.apply(income));
    }
    return result;
}
}
