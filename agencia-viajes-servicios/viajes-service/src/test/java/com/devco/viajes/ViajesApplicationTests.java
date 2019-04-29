package com.devco.viajes;

import com.devco.viajes.aplicacion.VuelosController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViajesApplicationTests {

	@Autowired
	VuelosController vuelosController;

	@Test
	public void contextLoads() {
		assertThat(vuelosController, is(notNullValue()));
	}

}
