package lab.rest1.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "loginId")
@ToString
@Entity
@Table(name = "TB_LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_generator")
    @SequenceGenerator(name = "login_generator", sequenceName = "SQ_LOGIN")
    @Column(name = "ID")
    private Long loginId;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private User user;

}
