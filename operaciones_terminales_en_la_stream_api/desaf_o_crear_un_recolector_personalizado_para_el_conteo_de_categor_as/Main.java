/*
Se requiere implementar un Collector personalizado que procese una lista de productos y cuente cuántos productos pertenecen a cada categoría.

En el método supplier(), devolver un nuevo HashMap.
En el método accumulator(), llamar al método get() sobre el product para obtener el valor de la clave "category" y pasarlo como primer parámetro de merge().
Para el segundo parámetro en el mismo método, proporcionar el valor inicial (1).
En el método combiner(), pasar el key de map2 como primer parámetro de merge().
Para el segundo parámetro en el mismo método, pasar el value de map2.
En el método finisher(), devolver el map sin modificarlo utilizando una lambda.
En el método characteristics(), devolver un conjunto que asegure que la colección permanezca sin cambios (IDENTITY_FINISH).
En el método collect(), pasar la implementación de la interfaz Collector (CategoryCountCollector).



*/


package com.example;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Map<String, String>> products = List.of(
            Map.of("name", "Laptop", "category", "Electronics"),
            Map.of("name", "Phone", "category", "Electronics"),
            Map.of("name", "Refrigerator", "category", "Home Appliances"),
            Map.of("name", "Microwave", "category", "Home Appliances"),
            Map.of("name", "Keyboard", "category", "Electronics")
        );

        // Using the custom `Collector`
        Map<String, Integer> categoryCount = products.parallelStream()
            .collect(new CategoryCountCollector());

        System.out.println(categoryCount);
    }
}

class CategoryCountCollector implements Collector<Map<String, String>, Map<String, Integer>, Map<String, Integer>> {

    @Override
    public Supplier<Map<String, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Integer>, Map<String, String>> accumulator() {
        return (map, product) -> map.merge(product.get("category"), 1, Integer::sum);
    }

    @Override
    public BinaryOperator<Map<String, Integer>> combiner() {
        return (map1, map2) -> {
            map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
            return map1;
        };
    }

    @Override
    public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
        return map -> map; // Simply return the collected data
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}