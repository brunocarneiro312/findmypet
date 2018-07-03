package lab.rest1.domain;

import lab.rest1.api.v1.model.LoginDTO;
import lab.rest1.api.v1.model.UserDTO;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
@ToString
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "SQ_USER")
    @Column(name = "ID")
    private Long userId;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_LOGIN",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "LOGIN_ID")
            }
    )
    private Login login;

    public UserDTO convert() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(login.getLoginId());
        loginDTO.setUsername(login.getUsername());
        loginDTO.setPassword(login.getPassword());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(userId);
        userDTO.setNome(nome);
        userDTO.setEmail(email);
        userDTO.setLoginDTO(loginDTO);

        return userDTO;
    }

}
