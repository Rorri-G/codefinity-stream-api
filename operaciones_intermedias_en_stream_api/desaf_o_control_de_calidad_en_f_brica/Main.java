/*
Una fábrica recibe múltiples lotes de piezas, pero algunas piezas son defectuosas y deben ser eliminadas para identificar componentes de alta calidad, los cuales deben mostrarse sin duplicados.

La clase PartBatch representa un lote de piezas, con un nombre de lote (batchName) y una lista de piezas (parts). Para acceder a la lista de piezas de un lote, se utiliza el método getParts(), y para obtener el nombre del lote, se utiliza el método getBatchName().

Extraer todas las piezas de cada lote usando el método flatMap().
Filtrar las piezas defectuosas verificando si el nombre de la pieza comienza con Defective usando el método filter().
Eliminar piezas duplicadas para obtener una lista de piezas de calidad únicas usando el método distinct().

*/
package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PartBatch> batches = List.of(
            new PartBatch("Batch A", List.of("Engine", "Wheel", "Defective Hood")),
            new PartBatch("Batch B", List.of("Headlight", "Wheel", "Steering Wheel")),
            new PartBatch("Batch C", List.of("Hood", "Headlight", "Defective Engine"))
        );

        List<String> qualityParts = batches.stream()
            .flatMap(batch -> batch.getParts().stream())
            .filter(part -> !part.startsWith("Defective"))
            .distinct()
            .toList();

        System.out.println("Quality parts: " + qualityParts);
    }
}

class PartBatch {
    private String batchName;
    private List<String> parts;

    public PartBatch(String batchName, List<String> parts) {
        this.batchName = batchName;
        this.parts = parts;
    }

    public String getBatchName() {
        return batchName;
    }

    public List<String> getParts() {
        return parts;
    }
}