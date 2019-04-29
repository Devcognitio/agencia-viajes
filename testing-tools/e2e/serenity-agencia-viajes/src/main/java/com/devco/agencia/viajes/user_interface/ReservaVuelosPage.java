package com.devco.agencia.viajes.user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ReservaVuelosPage {

    public static Target ORIGEN_INPUT = Target.the("el origen {0}")
            .located(By.id("origen"));
    public static Target DESTINO_INPUT = Target.the("el destino {0}")
            .located(By.id("destino"));
    public static Target FECHA_IDA_INPUT = Target.the("la fecha Ida {0}")
            .located(By.id("fechaIda"));
    public static Target FECHA_REGRESO_INPUT = Target.the("la fecha de regreso {0}")
            .located(By.id("fechaRegreso"));
    public static Target CONSULTAR_VIAJE_BOTON = Target.the("Boton consultar viaje")
            .located(By.id("consultarVuelosDisponibles"));
    public static Target SUBMIT_RESERVA = Target.the("Boton submit reserva")
            .located(By.id("submitReserva"));
    public static Target ID_RESERVA = Target.the("el id de reserva h2 {0}")
            .located(By.id("idReserva"));
    public static Target TITULO_DE_LA_PAGINA = Target.the("el titulo de la pagina en h2 {0}")
            .located(By.xpath("//h2"));



}
