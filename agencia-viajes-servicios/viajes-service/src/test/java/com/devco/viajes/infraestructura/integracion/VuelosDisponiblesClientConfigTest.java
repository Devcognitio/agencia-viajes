package com.devco.viajes.infraestructura.integracion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VuelosDisponiblesClientConfigTest {

    @Autowired
    VuelosDisponiblesAviancaClientMock aviancaClientMock;

    @Test
    public void cargaContextoAviancaClient() {
        assertThat(aviancaClientMock, is(notNullValue()));
    }
}