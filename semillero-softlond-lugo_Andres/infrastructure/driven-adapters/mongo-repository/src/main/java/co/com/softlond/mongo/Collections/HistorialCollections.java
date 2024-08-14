package co.com.softlond.mongo.Collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.List;

@Data
@Document(collection = "historial")
public class HistorialCollections {
    @Id
    private String id;
    private int contador;
    private String lastDescription;

}
