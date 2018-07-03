package lab.rest1.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_VIEW")
public class View {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "view_generator")
    @SequenceGenerator(name = "view_generator", sequenceName = "SQ_VIEW")
    @Column(name = "ID_VIEW")
    private Long viewId;

    @OneToOne
    @JoinColumn(name = "ID_LOCATION")
    private Location location;

    @OneToOne
    @JoinColumn(name = "ID_PET")
    private Pet pet;

    @Column(name = "OBSERVATION")
    private String observation;

    @Column(name = "REFERENCE")
    private String reference;

    public View() {
    }

    public View(Long viewId, Location location, String observation, String reference) {
        this.viewId = viewId;
        this.location = location;
        this.observation = observation;
        this.reference = reference;
    }

    public Long getViewId() {
        return viewId;
    }

    public void setViewId(Long viewId) {
        this.viewId = viewId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        View view = (View) o;
        return Objects.equals(viewId, view.viewId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(viewId);
    }

    @Override
    public String toString() {
        return "View{" +
                "viewId=" + viewId +
                ", location=" + location +
                ", observation='" + observation + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
