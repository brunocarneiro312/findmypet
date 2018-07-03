package lab.rest1.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_FOUND")
public class Found {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "found_generator")
    @SequenceGenerator(name = "found_generator", sequenceName = "SQ_FOUND")
    @Column(name = "ID_FOUND")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_LOCATION")
    private Location location;

    @OneToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @OneToOne
    @JoinColumn(name = "ID_PET")
    private Pet pet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FOUND_DATE", nullable = false)
    private Date foundDate;

    public Found() {

    }

    public Found(Location location, User user, Pet pet) {
        this.location = location;
        this.user = user;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Date foundDate) {
        this.foundDate = foundDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Found found = (Found) o;
        return Objects.equals(id, found.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Found{" +
                "id=" + id +
                ", location=" + location +
                ", user=" + user +
                ", pet=" + pet +
                '}';
    }
}
