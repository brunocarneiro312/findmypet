package lab.rest1.service.impl;

import lab.rest1.domain.Location;
import lab.rest1.domain.Owner;
import lab.rest1.domain.Pet;
import lab.rest1.domain.User;
import lab.rest1.repository.UserRepository;
import lab.rest1.service.UserService;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

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

}
