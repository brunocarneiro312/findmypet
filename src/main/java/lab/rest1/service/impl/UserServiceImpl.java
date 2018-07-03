package lab.rest1.service.impl;

import lab.rest1.api.v1.mapper.UserMapper;
import lab.rest1.api.v1.model.*;
import lab.rest1.domain.*;
import lab.rest1.repository.UserRepository;
import lab.rest1.service.UserService;
import org.apache.tomcat.util.digester.ArrayStack;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private UserRepository userRespository;

    @Autowired
    public UserServiceImpl(UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public void uploadPhoto(File photo) {
        // TODO
    }

    @Override
    public void markAsViewed(Pet pet) {
        // TODO
    }

    @Override
    public void askForReward(Owner owner) {
        // TODO
    }

    @Override
    public void save(User user) {
        userRespository.save(user);
    }

    @Override
    public void delete(User user) {
        userRespository.delete(user);
    }

    @Override
    public List<User> list() {
        List<User> users = new ArrayStack<>();
        userRespository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User find(User owner) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return userRespository.findById(id).get();
    }

    @Override
    public void shareLocation(Location location) {
        // TODO
    }

    /**
     * ============================
     * MÉTODOS DE UTILIDADE INTERNA
     * ============================
     */

    /**
     * converte User -> UserDTO
     */
    private UserDTO convert(User user) {
        UserDTO userDTO = userMapper.userToUserDTO(user);
        LoginDTO loginDTO = userMapper.loginToLoginDTO(user.getLogin());
        userDTO.setLoginDTO(loginDTO);
        return userDTO;
    }

    /**
     * converte UserDTO -> User
     */
    private User convert(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        Login login = userMapper.loginDTOToLogin(userDTO.getLoginDTO());
        user.setLogin(login);
        return userMapper.userDTOToUser(userDTO);
    }
}
