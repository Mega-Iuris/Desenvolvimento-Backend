package com.example.obra.service;

import com.example.obra.model.Obra;
import com.example.obra.repository.ObraRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    public List<Obra> listarObras() throws IOException {
        return obraRepository.getAll();
    }

    public Obra save(Obra novaObra) throws IOException {
        if(obraRepository.save(novaObra)) {
            return novaObra;
        }
        return null;
    }

    public Obra update(Obra obraAtualizada) throws IOException {
        if(obraRepository.update(obraAtualizada)) {
            return obraAtualizada;
        }
        return null;
    }
}
