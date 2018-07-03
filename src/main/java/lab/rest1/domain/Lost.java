package lab.rest1.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_LOST")
public class Lost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lost_generator")
    @SequenceGenerator(name = "lost_generator", sequenceName = "SQ_LOST")
    @Column(name = "ID_LOST")
    private Long lostId;

    @OneToOne
    @JoinColumn(name = "ID_PET")
    private Pet pet;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_LOCATION")
    private Location location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOST_DATE", nullable = false)
    private Date lostDate;

    @OneToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    public Lost() {
    }

    public Lost(Pet pet, Location location) {
        this.pet = pet;
        this.location = location;
    }

    public Long getLostId() {
        return lostId;
    }

    public void setLostId(Long lostId) {
        this.lostId = lostId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getLostDate() {
        return lostDate;
    }

    public void setLostDate(Date lostDate) {
        this.lostDate = lostDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lost lost = (Lost) o;
        return Objects.equals(lostId, lost.lostId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lostId);
    }

    @Override
    public String toString() {
        return "Lost{" +
                "lostId=" + lostId +
                ", pet=" + pet +
                ", location=" + location +
                '}';
    }
}
