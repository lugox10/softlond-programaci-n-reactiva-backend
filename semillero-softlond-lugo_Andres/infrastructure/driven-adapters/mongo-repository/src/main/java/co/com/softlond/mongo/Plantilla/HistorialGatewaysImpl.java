package co.com.softlond.mongo.Plantilla;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gatewaysInterface.HistorialGateways;
import co.com.softlond.mongo.Plantilla.repositorios.ReactiveHistorialMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class HistorialGatewaysImpl implements HistorialGateways {

    private final ReactiveHistorialMongoRepository reactHistorialMR;



    public HistorialGatewaysImpl(ReactiveHistorialMongoRepository reactHistorialMR) {
        this.reactHistorialMR = reactHistorialMR;
    }

    @Override
    public Mono<HistorialModel> crearHistorial(HistorialModel historial) {
        return reactHistorialMR.save(MapperPlantillaHistorial.toHistorialCollection(historial))
                .map(MapperPlantillaHistorial::toHistorialModel);
    }

    @Override
    public Mono<HistorialModel> actualizarHistorial(HistorialModel historial) {
        return reactHistorialMR.findById(historial.getId())
                .flatMap(existingHistorial -> {
                    existingHistorial.setContador(historial.getContador());
                    existingHistorial.setLastDescription(historial.getLastDescription());
                    return reactHistorialMR.save(existingHistorial);
                })
                .map(MapperPlantillaHistorial::toHistorialModel);
    }

    @Override
    public Mono<HistorialModel> obtenerHistorial() {
        return reactHistorialMR.findFirstByOrderById()
                .map(MapperPlantillaHistorial::toHistorialModel);
    }

    @Override
    public Mono<HistorialModel> obtenerHistorialPorDescripcion(String descripcion) {
        return reactHistorialMR.findByLastDescription(descripcion)
                .map(MapperPlantillaHistorial::toHistorialModel);
    }

    @Override
    public Mono<Void> eliminarHistorial(String id) {
        return reactHistorialMR.deleteById(id);
    }

    @Override
    public Mono<Void> eliminarHistorialPorDescripcion(String descripcion) {
        return reactHistorialMR.findByLastDescription(descripcion)
                .flatMap(reactHistorialMR::delete);
    }
}
