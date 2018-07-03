package lab.rest1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idLocation")
@ToString
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

}
