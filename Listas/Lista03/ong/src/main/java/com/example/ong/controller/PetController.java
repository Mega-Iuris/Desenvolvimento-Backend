package com.example.ong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ong.service.PetService;
import com.example.ong.model.Pet;

@RestController
@RequestMapping("/app/pets")
public class PetController {

    private PetService petService;

    @Autowired  
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> listarPets() throws Exception {
        return petService.getPetAll();
    }

    @PostMapping
    public String cadastrarPet(@RequestBody Pet pet) throws Exception {
        return petService.cadastrarPet(pet);
    }
}
