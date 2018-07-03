package lab.rest1.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_OWNER")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_generator")
    @SequenceGenerator(name = "owner_generator", sequenceName = "SQ_OWNER")
    @Column(name = "ID_OWNER")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "owner")
    private List<Pet> petList;

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
