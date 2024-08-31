package com.example.ong.service;

import com.example.ong.model.Pet;
import com.example.ong.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getPetAll() throws Exception {
        return petRepository.getPetAll();
    }

    public String cadastrarPet(Pet pet) throws Exception {
        if (petRepository.save(pet)) {
            return "Pet cadastrado com sucesso!";
        } else {
            return "Erro ao cadastrar o pet. Verifique se o ID já existe.";
        }
    }
}
