package co.com.softlond.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HistorialModel {

    private String id;
    private int contador;
    private String lastDescription;


}
