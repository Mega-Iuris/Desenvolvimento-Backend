package com.example.obra.repository;

import java.io.File;
import java.io.IOException;
import com.example.obra.model.Obra;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ObraRepository {
    private static final int ZERO_BYTES = 0;
    private ObjectMapper objectMapper = new ObjectMapper();
    private File arquivo = new File("src/main/resources/database/tb_obra.json");

    public List<Obra> getAll() throws IOException {
        
        if (!arquivo.exists()) {
            arquivo.createNewFile();
            return new ArrayList<>(); 
        }
        
        if (arquivo.length() == ZERO_BYTES) {
            return new ArrayList<>(); 
        }
        return objectMapper.readValue(arquivo, new TypeReference<List<Obra>>() {});
    }

    public boolean save(Obra novaObra) throws IOException {
        List<Obra> obras = this.getAll(); 
        
        for (Obra obra : obras) {
            if (obra.getId() == novaObra.getId()) {
                return false; 
            }
        }
        
        obras.add(novaObra);
        objectMapper.writeValue(arquivo, obras);
        return true;
    }

    public boolean update(Obra obraAtualizada) throws IOException {
        List<Obra> obras = this.getAll();

        for (Obra obra : obras) {
            if (obra.getId() == obraAtualizada.getId()) {
                obras.remove(obra);
                obras.add(obraAtualizada);
                objectMapper.writeValue(arquivo, obras);
                return true;
            }
        }
        return false;
    }

}