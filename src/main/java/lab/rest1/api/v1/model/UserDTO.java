package lab.rest1.api.v1.model;

import lab.rest1.domain.Login;
import lab.rest1.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String nome;

    private String email;

    private LoginDTO loginDTO;

    public User convert() {

        Login login = new Login();
        login.setLoginId(loginDTO.getId());
        login.setUsername(loginDTO.getUsername());
        login.setPassword(loginDTO.getPassword());

        return new User(id, nome, email, login);
    }

}
