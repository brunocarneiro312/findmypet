package lab.rest1.domain;

import lab.rest1.domain.enums.PetBehaviour;
import lab.rest1.domain.enums.PetCategory;
import lab.rest1.domain.enums.PetClass;
import lab.rest1.domain.enums.PetSize;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
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

}
