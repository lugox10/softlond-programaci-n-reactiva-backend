package co.com.softlond.mongo.Plantilla.repositorios;

import co.com.softlond.mongo.Collections.HistorialCollections;
import co.com.softlond.mongo.Collections.PlantillaCollections;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface ReactivePlantillaMongoRepository extends ReactiveMongoRepository<PlantillaCollections, String> {

}
