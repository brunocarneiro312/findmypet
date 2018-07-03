package lab.rest1.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_generator")
    @SequenceGenerator(name = "location_generator", sequenceName = "SQ_LOCATION")
    @Column(name = "ID_LOCATION")
    private Long idLocation;

    @Column(name = "LONGITUDE", nullable = false)
    private String longitude;

    @Column(name = "LATITUDE", nullable = false)
    private String latitude;

    public Location() {
    }

    public Location(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(idLocation, location.idLocation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLocation);
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
