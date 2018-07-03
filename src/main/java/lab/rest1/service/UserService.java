package lab.rest1.service;

import lab.rest1.api.v1.model.UserDTO;
import lab.rest1.domain.Owner;
import lab.rest1.domain.Pet;
import lab.rest1.domain.User;

import java.io.File;

public interface UserService extends CrudService<User>, LocationService {

    /** Faz upload de fotografia */
    void uploadPhoto(File photo);

    /** Marca animal como visualizado */
    void markAsViewed(Pet pet);

    /** Solicita recompensa */
    void askForReward(Owner owner);

}
