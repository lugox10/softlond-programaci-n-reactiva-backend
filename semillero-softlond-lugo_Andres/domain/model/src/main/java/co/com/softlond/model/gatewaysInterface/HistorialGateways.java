package co.com.softlond.model.gatewaysInterface;

import co.com.softlond.model.HistorialModel;
import reactor.core.publisher.Mono;

public interface HistorialGateways {

    Mono<HistorialModel> crearHistorial(HistorialModel historial);

    Mono<HistorialModel> actualizarHistorial(HistorialModel historial);

    Mono<HistorialModel> obtenerHistorial();

    Mono<HistorialModel> obtenerHistorialPorDescripcion(String descripcion);

    Mono<Void> eliminarHistorial(String id);

    Mono<Void> eliminarHistorialPorDescripcion(String descripcion);

}
