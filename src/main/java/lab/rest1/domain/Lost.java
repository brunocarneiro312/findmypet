package lab.rest1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "lostId")
@ToString
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
    @Column(name = "LOST_DATE")
    private Date lostDate;

}
