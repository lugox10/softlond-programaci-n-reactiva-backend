package co.com.softlond.usecase.Plantilla;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gatewaysInterface.HistorialGateways;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class HistorialUseCase {

    private final HistorialGateways historialGateways;

    public HistorialUseCase(HistorialGateways historialGateways) {
        this.historialGateways = historialGateways;
    }

    public Mono<Void> actualizarHistorial(PlantillaModel plantilla) {
        return historialGateways.obtenerHistorialPorDescripcion(plantilla.getDescripcion())
                .switchIfEmpty(Mono.defer(() -> {
                    HistorialModel nuevoHistorial = HistorialModel.builder()
                            .contador(1)
                            .lastDescription(plantilla.getDescripcion())
                            .build();
                    return historialGateways.crearHistorial(nuevoHistorial);
                }))
                .flatMap(existingHistorial -> {
                    existingHistorial.setContador(existingHistorial.getContador() + 1);
                    existingHistorial.setLastDescription(plantilla.getDescripcion());
                    return historialGateways.actualizarHistorial(existingHistorial);
                })
                .then();
    }

    public Mono<HistorialModel> obtenerHistorial() {
        return historialGateways.obtenerHistorial();
    }

    public Mono<Void> eliminarHistorial(String id) {
        return historialGateways.eliminarHistorial(id);
    }
}
