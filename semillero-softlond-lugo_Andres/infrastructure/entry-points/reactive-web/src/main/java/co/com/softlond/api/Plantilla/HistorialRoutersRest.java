/*package co.com.softlond.api.Plantilla;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HistorialRoutersRest {


    public RouterFunction<ServerResponse> historialRoutes(HistoriaHandler historiaHandler) {
        return route(POST("/api/historial/crear"), historiaHandler::crearHistorial)
                .andRoute(PUT("/api/historial/actualizar"), historiaHandler::actualizarHistorial)
                .andRoute(GET("/api/historial/obtener"), historiaHandler::obtenerHistorial)
                .andRoute(GET("/api/historial/obtenerPorDescripcion"), historiaHandler::obtenerHistorialPorDescripcion)
                .andRoute(DELETE("/api/historial/eliminar/{id}"), historiaHandler::eliminarHistorial)
                .andRoute(DELETE("/api/historial/eliminarPorDescripcion/{descripcion}"), historiaHandler::eliminarHistorialPorDescripcion);
    }

}*/
