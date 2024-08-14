package co.com.softlond.mongo.Plantilla;

import co.com.softlond.mongo.Plantilla.repositorios.ReactivePlantillaMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gatewaysInterface.PlantillaGateways;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.OptionalLong;

@Repository
public class PlantillaGatewaysImpl implements PlantillaGateways {    

    @Autowired
    private ReactivePlantillaMongoRepository reactivePlantillaMongoRepository;

    @Override
    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        return reactivePlantillaMongoRepository.save(MapperPlantillaHistorial.toCollection(plantilla))
                .map(plantillaEntity -> MapperPlantillaHistorial.toModel(plantillaEntity));
    }

    @Override
    public Flux<PlantillaModel> listarPlantilla() {
        return reactivePlantillaMongoRepository.findAll()
                .map(plantillaEntity -> MapperPlantillaHistorial.toModel(plantillaEntity));

    }

    @Override
    public Mono<OptionalLong> eliminarPlantilla(Long id) {
        return reactivePlantillaMongoRepository.delete(MapperPlantillaHistorial.toCollection(PlantillaModel.builder().id(id).build()))
                .then(Mono.fromCallable(() -> OptionalLong.of(id)));

    }



}
