package lab.rest1.bootstrap;

import lab.rest1.domain.*;
import lab.rest1.domain.enums.PetBehaviour;
import lab.rest1.domain.enums.PetCategory;
import lab.rest1.domain.enums.PetClass;
import lab.rest1.domain.enums.PetSize;
import lab.rest1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Date;

@Configuration
public class H2Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private PetRepository petRepository;
    private OwnerRepository ownerRepository;
    private LostRepository lostRepository;
    private FoundRepository foundRepository;

    @Autowired
    public H2Bootstrap(UserRepository userRepository,
                       PetRepository petRepository,
                       OwnerRepository ownerRepository,
                       LostRepository lostRepository,
                       FoundRepository foundRepository) {

        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.lostRepository = lostRepository;
        this.foundRepository = foundRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println();
        System.out.println("===========");
        System.out.println("H2Bootstrap");
        System.out.println("===========");
        System.out.println();

        // Declarando Logins
        Login loginSarah = new Login();
        Login loginThiago = new Login();
        Login loginBruno = new Login();

        loginSarah.setUsername("sarah.carneiro");
        loginThiago.setUsername("thiago.carneiro");
        loginBruno.setUsername("bruno.carneiro312");

        loginSarah.setPassword("pass123");
        loginThiago.setPassword("pass123");
        loginBruno.setPassword("pass123");

        // Declarando Users
        User sarah = new User();
        User thiago = new User();
        User bruno = new User();

        sarah.setNome("Sarah de Souza Ferreira Carneiro");
        thiago.setNome("Thiago de Souza Ferreira Carneiro");
        bruno.setNome("Bruno de Souza Ferreira Carneiro");

        sarah.setEmail("sarah.carneiro312@gmail.com");
        thiago.setEmail("thiago.carneiro@gmail.com");
        bruno.setEmail("bruno.carneiro312@gmail.com");

        sarah.setLogin(loginSarah);
        thiago.setLogin(loginThiago);
        bruno.setLogin(loginBruno);

        // Declarando Owners
        Owner ownerSarah = new Owner();
        Owner ownerBruno = new Owner();
        Owner ownerThiago = new Owner();

        ownerSarah.setUser(sarah);
        ownerBruno.setUser(bruno);
        ownerThiago.setUser(thiago);

        // Declarando Pets
        Pet jupinho = new Pet();
        Pet dolinho = new Pet();
        Pet nipple  = new Pet();

        jupinho.setId(1L);
        dolinho.setId(2L);
        nipple.setId(3L);

        jupinho.setName("Bartolomeu");
        dolinho.setName("Dolinho");
        nipple.setName("Nippow");

        jupinho.setOwner(ownerSarah);
        dolinho.setOwner(ownerBruno);
        nipple.setOwner(ownerThiago);

        jupinho.setPetBehaviour(PetBehaviour.MODERATE);
        dolinho.setPetBehaviour(PetBehaviour.MEEK);
        nipple.setPetBehaviour(PetBehaviour.INTERACTIVE);

        jupinho.setPetCategory(PetCategory.CAT);
        dolinho.setPetCategory(PetCategory.CAT);
        nipple.setPetCategory(PetCategory.DOG);

        jupinho.setPetClass(PetClass.MAMMAL);
        dolinho.setPetClass(PetClass.MAMMAL);
        nipple.setPetClass(PetClass.MAMMAL);

        jupinho.setPetSize(PetSize.NORMAL);
        dolinho.setPetSize(PetSize.NORMAL);
        nipple.setPetSize(PetSize.NORMAL);

        saveOwner(ownerSarah);
        saveOwner(ownerThiago);
        saveOwner(ownerBruno);

        savePet(jupinho);
        savePet(dolinho);
        savePet(nipple);


        Location locationDolinhoLost = new Location();
        locationDolinhoLost.setLatitude("700000");
        locationDolinhoLost.setLongitude("800000");

        Lost dolinhoLost = new Lost();
        dolinhoLost.setLocation(locationDolinhoLost);
        dolinhoLost.setPet(dolinho);
        dolinhoLost.setLostDate(new Date());

        lostRepository.save(dolinhoLost);

        Found dolinhoFound = new Found();
        dolinhoFound.setLocation(locationDolinhoLost);
        dolinhoFound.setPet(dolinho);
        dolinhoFound.setUser(bruno);
        dolinhoFound.setFoundDate(new Date());

        foundRepository.save(dolinhoFound);


    }

    private void saveUser(User user) {
        userRepository.save(user);
    }

    private void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    private void savePet(Pet pet) {
        petRepository.save(pet);
    }
}
