package co.com.softlond.mongo.Plantilla;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.mongo.Collections.HistorialCollections;
import co.com.softlond.mongo.Collections.PlantillaCollections;
import java.util.stream.Collectors;

public class MapperPlantillaHistorial {

    public static PlantillaModel toModel(PlantillaCollections plantillaCollections) {
        return PlantillaModel.builder()
                .id(plantillaCollections.getId())
                .nombre(plantillaCollections.getNombre())
                .fecha(plantillaCollections.getFecha())
                .descripcion(plantillaCollections.getDescripcion())
                .fechaActualizacion(plantillaCollections.getFechaActualizacion())
                .build();
    }

    public static PlantillaCollections toCollection(PlantillaModel plantillaModel) {
        PlantillaCollections plantillaCollections = new PlantillaCollections();
        plantillaCollections.setId(plantillaModel.getId());
        plantillaCollections.setNombre(plantillaModel.getNombre());
        plantillaCollections.setFecha(plantillaModel.getFecha());
        plantillaCollections.setDescripcion(plantillaModel.getDescripcion());
        plantillaCollections.setFechaActualizacion(plantillaModel.getFechaActualizacion());
        return plantillaCollections;
    }

    public static HistorialCollections toHistorialCollection(HistorialModel historialModel) {
        HistorialCollections historialCollections = new HistorialCollections();
        historialCollections.setId(historialModel.getId());
        historialCollections.setContador(historialModel.getContador());
        historialCollections.setLastDescription(historialModel.getLastDescription());
        return historialCollections;
    }

    public static HistorialModel toHistorialModel(HistorialCollections historialCollections) {
        return HistorialModel.builder()
                .id(historialCollections.getId())
                .contador(historialCollections.getContador())
                .lastDescription(historialCollections.getLastDescription())
                .build();
    }
}