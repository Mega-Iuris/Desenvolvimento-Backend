package com.example.obra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.obra.model.Obra;
import com.example.obra.service.ObraService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @GetMapping
    public ResponseEntity<List<Obra>> getAll() throws IOException{
        List<Obra> listaObras = obraService.listarObras();
        return ResponseEntity.ok().body(listaObras);
    }

    @PostMapping
    public ResponseEntity<Obra> cadastrarObra(@RequestBody Obra obra ) throws IOException{
        if(obraService.save(obra) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(obra);
    }

    @PutMapping
    public ResponseEntity<Obra> atualizarObra(@RequestBody Obra obra) throws IOException{
        if(obraService.update(obra) != null){
            return ResponseEntity.ok().body(obra);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
