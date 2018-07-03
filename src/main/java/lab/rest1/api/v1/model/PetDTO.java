package lab.rest1.api.v1.model;

import lab.rest1.domain.enums.PetBehaviour;
import lab.rest1.domain.enums.PetCategory;
import lab.rest1.domain.enums.PetClass;
import lab.rest1.domain.enums.PetSize;

public class PetDTO {

    private String name;

    private PetClass petClass;

    private PetCategory petCategory;

    private PetSize petSize;

    private PetBehaviour petBehaviour;

    private OwnerDTO ownerDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetClass getPetClass() {
        return petClass;
    }

    public void setPetClass(PetClass petClass) {
        this.petClass = petClass;
    }

    public PetCategory getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(PetCategory petCategory) {
        this.petCategory = petCategory;
    }

    public PetSize getPetSize() {
        return petSize;
    }

    public void setPetSize(PetSize petSize) {
        this.petSize = petSize;
    }

    public PetBehaviour getPetBehaviour() {
        return petBehaviour;
    }

    public void setPetBehaviour(PetBehaviour petBehaviour) {
        this.petBehaviour = petBehaviour;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }
}
