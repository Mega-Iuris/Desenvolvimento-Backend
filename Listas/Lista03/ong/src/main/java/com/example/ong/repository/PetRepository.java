package com.example.ong.repository;

import com.example.ong.model.Pet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository  // Esta anotação marca a classe como um repositório Spring
public class PetRepository {

    private static final int ZERO_BYTO = 0;
    private final File arquivo = new File("src/main/resources/database/tb_pets.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Pet> getPetAll() throws Exception {
        if(!arquivo.exists()){
            arquivo.createNewFile();
            return new ArrayList<>();
        }

        if (arquivo.length() == ZERO_BYTO) {
            return new ArrayList<>();
        }

        return objectMapper.readValue(arquivo, new TypeReference<ArrayList<Pet>>() {});
    }

    public boolean save(Pet pet) throws Exception {
        List<Pet> pets = getPetAll();

        for(Pet bd : pets){
            if(bd.getId() == pet.getId()){
                return false;
            }
        }

        pets.add(pet);
        objectMapper.writeValue(arquivo, pets);
        return true;
    }
}
