package com.example.atividade2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/medias-de-calor")
public class Atividade2Application {

	private MediasDeCalor mediasDeCalor = new MediasDeCalor();

	@GetMapping
	public List<IlhaDeCalor> getIlhasDeCalor() {
		return mediasDeCalor.getIlhasDeCalor();
	}

@PostMapping
public ResponseEntity<String> adicionarMediaDeCalor(@RequestBody IlhaDeCalor ilhaDeCalor) {
    for (IlhaDeCalor faixaDeCalor : mediasDeCalor.getIlhasDeCalor()) {
        if (faixaDeCalor.getId() == ilhaDeCalor.getId()) {           
            return ResponseEntity.status(400).body("Já existe uma ilha de calor com o mesmo ID");
        }
    }
    mediasDeCalor.adicionarMediaDeCalor(ilhaDeCalor);
    String mensagemSucesso = "Ilha de calor " + ilhaDeCalor.getBairro() + " adicionada com sucesso!";
    return ResponseEntity.status(201).body(mensagemSucesso);
}



	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

}
