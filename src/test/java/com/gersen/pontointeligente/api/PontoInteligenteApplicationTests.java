package com.gersen.pontointeligente.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // ira aplicar o que está em application-test.properties, que está acessando o H2
public class PontoInteligenteApplicationTests {

	@Test
	public void contextLoads() {
	}

}
