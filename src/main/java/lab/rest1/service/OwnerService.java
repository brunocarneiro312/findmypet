package lab.rest1.service;

import lab.rest1.domain.Owner;
import lab.rest1.domain.Pet;
import lab.rest1.domain.User;

import java.io.File;

public interface OwnerService extends CrudService<Owner>, LocationService {

    /** Faz upload de fotografia do animal */
    void uploadPetPhoto(File photo);

    /** Registra animal como perdido */
    void registerAsLost(Pet pet);

    /** Registra animal como encontrado */
    void registerAsFound(Pet pet);

    /** Libera pagamento de recompensa ao usuário */
    void payReward(User user);

    /** Solicita ao usuário a localização da visualização do animal perdido */
    void askForLocation(User user);

}
