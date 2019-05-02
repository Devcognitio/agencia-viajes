package com.devco.agencia.viajes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.devco.agencia.viajes.user_interface.ReservaVuelosPage.TITULO_DE_LA_PAGINA;

public class ElTituloDeLaPagina implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(TITULO_DE_LA_PAGINA)
                .viewedBy(actor)
                .value();
    }

    public static Question<String> es() {
        return new ElTituloDeLaPagina();
    }
}
