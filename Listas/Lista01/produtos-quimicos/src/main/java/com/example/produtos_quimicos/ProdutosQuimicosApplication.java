package com.example.produtos_quimicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app")
public class ProdutosQuimicosApplication {
	
	public static final String SENHA = "senha123";

	@GetMapping("/login/{login}")
	public String validarAcesso(@PathVariable("login") String login){
		if(login.equals(SENHA)){
			return "Entrada autorizada";
		}
		return "Entrada não autorizada";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutosQuimicosApplication.class, args);
	}

}
