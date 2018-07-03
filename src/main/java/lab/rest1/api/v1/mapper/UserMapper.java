package lab.rest1.api.v1.mapper;

import lab.rest1.api.v1.model.LoginDTO;
import lab.rest1.api.v1.model.UserDTO;
import lab.rest1.domain.Login;
import lab.rest1.domain.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

    Login loginDTOToLogin(LoginDTO loginDTO);

    LoginDTO loginToLoginDTO(Login login);

}
