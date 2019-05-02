package com.devco.agencia.viajes.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VuelosDisponiblesPage {

    public static Target PRIMER_VUELO_EN_LISTA = Target.the("el origen {0}")
            .located(By.xpath("//table[@id = 'tablaVuelosDisponibles']/tbody/tr[1]"));
    public static Target SEGUNDO_VUELO_EN_LISTA = Target.the("el origen {0}")
            .located(By.xpath("//table[@id = 'tablaVuelosDisponibles']/tbody/tr[2]"));
    public static Target FILAS_TABLA_VUELOS_DISPONIBLES = Target.the("tabla vuelos disponibles {0}")
            .located(By.xpath("//table[@id = 'tablaVuelosDisponibles']/tbody/tr"));
}
