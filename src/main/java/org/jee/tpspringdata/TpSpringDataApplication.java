package org.jee.tpspringdata;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.enums.Genre;
import org.jee.tpspringdata.repositories.CentreRestRepository;
import org.jee.tpspringdata.repositories.EtudiantRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpSpringDataApplication implements CommandLineRunner {
    @Autowired
   EtudiantRestRepository etudiantRestRepository;
    @Autowired
    CentreRestRepository centreRestRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpSpringDataApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //build centre

        Centre centre = Centre.builder()
                .nom("EMSI CASA")
                .adresse("Bvd Hassan II")
                .build();

        centreRestRepository.save(centre);

        Etudiant etudiant = Etudiant.builder()
                .nom("Alpha")
                .prenom("Ahmed")
                .genre(Genre.HOMME)
                .centre(centre)
                .build();
        etudiantRestRepository.save(etudiant);

        Etudiant etudiantx = Etudiant.builder()
                .nom("ElAdraoui")
                .prenom("Badr")
                .centre(centre)
                .genre(Genre.HOMME)
                .build();
        etudiantRestRepository.save(etudiantx);

        Etudiant etudiant2 = Etudiant.builder()
                .nom("Elmou")
                .prenom("Imane")
                .centre(centre)
                .genre(Genre.FEMME)
                .build();
        etudiantRestRepository.save(etudiant2);

        Etudiant etudiant3 = Etudiant.builder()
                .nom("Elmoussawi")
                .prenom("Mustapha")
                .centre(centre)
                .genre(Genre.HOMME)
                .build();
        etudiantRestRepository.save(etudiant3);

        Etudiant etudiant4 = Etudiant.builder()
                .nom("HHHHHH")
                .prenom("HHHHHHHHHHH")
                .centre(centre)
                .genre(Genre.FEMME)
                .build();
        etudiantRestRepository.save(etudiant4);


    }
}
