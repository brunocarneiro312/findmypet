package lab.rest1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
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

}
