/*package co.com.softlond.api.Plantilla;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.usecase.Plantilla.HistorialUseCase;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class HistoriaHandler {

    private final HistorialUseCase historialUseCase;

    public HistoriaHandler(HistorialUseCase historialUseCase) {
        this.historialUseCase = historialUseCase;
    }

    public Mono<ServerResponse> crearHistorial(ServerRequest request) {
        return request.bodyToMono(HistorialModel.class)
                .flatMap(historialUseCase::crearHistorial)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }


    public Mono<ServerResponse> actualizarHistorial(ServerRequest request) {
        return request.bodyToMono(HistorialModel.class)
                .flatMap(historialUseCase::actualizarHistorial)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> obtenerHistorial(ServerRequest request) {
        return request.bodyToMono(HistorialModel.class)
                .flatMap(historialUseCase::obtenerHistorial)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> obtenerHistorialPorDescripcion(ServerRequest request) {
        return request.bodyToMono(HistorialModel.class)
                .flatMap(historialUseCase::obtenerHistorialPorDescripcion)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> eliminarHistorial(ServerRequest request) {
        String id = request.pathVariable("id");
        return historialUseCase.eliminarHistorial(id)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> eliminarHistorialPorDescripcion(ServerRequest request) {
        String descripcion = request.pathVariable("descripcion");
        return historialUseCase.eliminarHistorialPorDescripcion(descripcion)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }




}*/
