package co.com.softlond.mongo.Plantilla.repositorios;

import co.com.softlond.mongo.Collections.HistorialCollections;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ReactiveHistorialMongoRepository extends ReactiveMongoRepository<HistorialCollections, String> {

    Mono<HistorialCollections> findFirstByOrderById();
    Mono<HistorialCollections> findByLastDescription(String lastDescription);

}
