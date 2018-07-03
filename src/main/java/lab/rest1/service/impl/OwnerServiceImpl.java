package lab.rest1.service.impl;

import lab.rest1.domain.Location;
import lab.rest1.domain.Owner;
import lab.rest1.domain.Pet;
import lab.rest1.domain.User;
import lab.rest1.repository.OwnerRepository;
import lab.rest1.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void uploadPetPhoto(File photo) {

    }

    @Override
    public void registerAsLost(Pet pet) {

    }

    @Override
    public void registerAsFound(Pet pet) {

    }

    @Override
    public void payReward(User user) {

    }

    @Override
    public void askForLocation(User user) {

    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public List<Owner> list() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner find(Owner owner) {
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).get();
    }

    @Override
    public void shareLocation(Location location) {

    }
}
