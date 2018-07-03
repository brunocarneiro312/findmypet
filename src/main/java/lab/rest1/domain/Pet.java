package lab.rest1.domain;

import lab.rest1.domain.enums.PetBehaviour;
import lab.rest1.domain.enums.PetCategory;
import lab.rest1.domain.enums.PetClass;
import lab.rest1.domain.enums.PetSize;

import javax.persistence.*;

@Entity
@Table(name = "TB_PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_generator")
    @SequenceGenerator(name = "pet_generator", sequenceName = "SQ_PET")
    @Column(name = "PET_ID")
    private Long id;

    @Column(name = "PET_NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "PET_CLASS")
    private PetClass petClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "PET_CATEGORY")
    private PetCategory petCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "PET_SIZE")
    private PetSize petSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "PET_BEHAVIOUR")
    private PetBehaviour petBehaviour;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_OWNER")
    private Owner owner;

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
