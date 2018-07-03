package lab.rest1.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "viewId")
@ToString
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

}
