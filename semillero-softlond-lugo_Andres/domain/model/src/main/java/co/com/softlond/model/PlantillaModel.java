package co.com.softlond.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlantillaModel {
    private Long id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private Date fechaActualizacion;

}
