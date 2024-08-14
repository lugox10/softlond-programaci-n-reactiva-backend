package co.com.softlond.usecase.Plantilla;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gatewaysInterface.PlantillaGateways;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.OptionalLong;

@Service
public class PlantillaOperationsUseCase {

    private final PlantillaGateways plantillaGateways;
    private final HistorialUseCase historialUseCase;

    public PlantillaOperationsUseCase(PlantillaGateways plantillaGateways, HistorialUseCase historialUseCase) {
        this.plantillaGateways = plantillaGateways;
        this.historialUseCase = historialUseCase;
    }

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        plantilla.setFechaActualizacion(new Date(System.currentTimeMillis()));
        return plantillaGateways.savePlantilla(plantilla)
                .flatMap(savedPlantilla -> historialUseCase.actualizarHistorial(savedPlantilla).thenReturn(savedPlantilla));
    }

    public Flux<PlantillaModel> listarPlantilla() {
        return plantillaGateways.listarPlantilla();
    }

    public Mono<OptionalLong> eliminarPlantilla(Long id) {
        return plantillaGateways.eliminarPlantilla(id);
    }

    public Mono<HistorialModel> verHistorial() {
        return historialUseCase.obtenerHistorial();
    }
}
