package co.com.softlond.api.Plantilla;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.usecase.Plantilla.PlantillaOperationsUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlantillaHandler {

    private final PlantillaOperationsUseCase plantillaOperationsUseCase;

    public PlantillaHandler(PlantillaOperationsUseCase plantillaOperationsUseCase) {
        this.plantillaOperationsUseCase = plantillaOperationsUseCase;
    }

    public Mono<ServerResponse> savePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaOperationsUseCase::savePlantilla)
                .flatMap(plantilla -> ServerResponse.ok().bodyValue(plantilla))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> listarPlantilla(ServerRequest request) {
        Flux<PlantillaModel> plantillaList = plantillaOperationsUseCase.listarPlantilla();
        return ServerResponse.ok().body(plantillaList, PlantillaModel.class);
    }

    public Mono<ServerResponse> eliminarPlantilla(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        return plantillaOperationsUseCase.eliminarPlantilla(id)
                .flatMap(plantilla -> ServerResponse.ok().bodyValue(plantilla))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> verHistorial(ServerRequest request) {
        return plantillaOperationsUseCase.verHistorial()
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}
