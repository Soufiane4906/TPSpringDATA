package org.jee.tpspringdata;

import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.enums.Genre;
import org.jee.tpspringdata.repositories.EtudiantRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpSpringDataApplication implements CommandLineRunner {
    @Autowired
   EtudiantRestRepository etudiantRestRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpSpringDataApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Etudiant etudiant = Etudiant.builder()
                .nom("Diallo")
                .prenom("Mamadou")
                .genre(Genre.HOMME)
                .build();
        etudiantRestRepository.save(etudiant);

        Etudiant etudiantx = Etudiant.builder()
                .nom("Doe")
                .prenom("John")
                .genre(Genre.HOMME)
                .build();
        etudiantRestRepository.save(etudiantx);
        //ajouter d'autres étudiants

        Etudiant etudiant2 = Etudiant.builder()
                .nom("Doe")
                .prenom("Jane")
                .genre(Genre.FEMME)
                .build();
        etudiantRestRepository.save(etudiant2);

        Etudiant etudiant3 = Etudiant.builder()
                .nom("Doe")
                .prenom("Jack")
                .genre(Genre.HOMME)
                .build();
        etudiantRestRepository.save(etudiant3);

        Etudiant etudiant4 = Etudiant.builder()
                .nom("Doe")
                .prenom("Jill")
                .genre(Genre.FEMME)
                .build();
        etudiantRestRepository.save(etudiant4);


    }
}
