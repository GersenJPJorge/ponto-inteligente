package com.gersen.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // essa linha usamos quando ainda não temos a autenticação via Token

@SpringBootApplication // essa linha usamos quando temos a autenticação via Token
@EnableCaching // O spring saberá que tem usar ehcache - libera a dependencia do ehache e o arquivo ehcache.xml do resource
public class PontoInteligenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoInteligenteApplication.class, args);
	}
         
}
