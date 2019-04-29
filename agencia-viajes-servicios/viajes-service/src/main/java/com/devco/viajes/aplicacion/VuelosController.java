package com.devco.viajes.aplicacion;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import com.devco.viajes.dominio.servicios.VueloServiceImp;
import com.devco.viajes.excepciones.ParametrosIncorrectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value="/vuelos")
public class VuelosController {

    @Autowired
    private VueloServiceImp vuelosService;

    @RequestMapping(method = RequestMethod.GET, value = "/disponibles")
    public ResponseEntity<List<Vuelo>> consultarVuelosDisponibles(@RequestParam(required = true) String origen,
                                                                  @RequestParam(required = true) String destino,
                                                                  @RequestParam(required = true) String fechaIda,
                                                                  @RequestParam(required = true) String fechaRegreso,
                                                                  @RequestParam(required = false, defaultValue = "1") String nroPasajeros,
                                                                  @RequestParam(required = false, defaultValue = "economica") String clase){
        try {
            ReservaViaje reservaViaje = new ReservaViaje.ReservaViajeBuilder()
                    .conOrigen(origen)
                    .conDestino(destino)
                    .conFechaIda(fechaIda)
                    .conFechaRegreso(fechaRegreso)
                    .conNroPasajeros(nroPasajeros)
                    .conClase(clase)
                    .build();

            System.out.println(reservaViaje.getIdReserva());

            List<Vuelo> vuelos = vuelosService.consultarVuelosDisponibles(reservaViaje);

            return ResponseEntity.status(HttpStatus.OK).body(vuelos);
        }catch (ParametrosIncorrectos exc){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bad Request", exc);
        }catch (Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", exc);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seleccionar")
    public ResponseEntity<ReservaViaje> seleccionarVuelos (@RequestBody ReservaViaje reservaViaje){
        // TODO: Hacer el código Necesario
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaViaje);
    }

}
