package co.com.softlond.model.gatewaysInterface;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.OptionalLong;

public interface PlantillaGateways {
    Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla);

    Flux<PlantillaModel> listarPlantilla();

    Mono<OptionalLong> eliminarPlantilla(Long id);


}
