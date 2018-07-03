package lab.rest1.service.impl;

import lab.rest1.domain.Pet;
import lab.rest1.repository.PetRepository;
import lab.rest1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void save(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        this.petRepository.delete(pet);
    }

    @Override
    public List<Pet> list() {
        return this.petRepository.findAll();
    }

    @Override
    public Pet find(Pet pet) {
        return null;
    }

    @Override
    public Pet findById(Long id) {
        return this.petRepository.findById(id).get();
    }
}
