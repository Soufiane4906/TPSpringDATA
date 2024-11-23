package org.jee.tpspringdata.controllers;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.dtos.CentreDto;
import org.jee.tpspringdata.dtos.EtudiantDto;
import org.jee.tpspringdata.enums.Genre;
import org.jee.tpspringdata.repositories.CentreRestRepository;
import org.jee.tpspringdata.repositories.EtudiantRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EtudiantController {
    @Autowired
    private CentreRestRepository centreRepository;

    @Autowired
    private EtudiantRestRepository etudiantRepository;


@QueryMapping()
    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }

@QueryMapping()
public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

@QueryMapping()
    public Centre getCentre(@Argument Long id) {
        return centreRepository.findById(id).orElse(null);
    }

    @QueryMapping()
    public Etudiant getEtudiant(@Argument Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

@MutationMapping()
public Etudiant addEtudiant(@Argument EtudiantDto etudiant) {
    Centre centre = centreRepository.findById(etudiant.idCentre()).orElse(null);
    if (centre == null) {
        return null;
    }
    Etudiant newEtudiant = new Etudiant(etudiant.nom(), etudiant.prenom(), Genre.valueOf(etudiant.genre()), centre);

    return etudiantRepository.save(newEtudiant);
}

@MutationMapping()
public Etudiant updateEtudiant(@Argument Long id, @Argument EtudiantDto etudiantDto) {
    Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
    if (etudiant == null) {
        return null;
    }
    etudiant.setNom(etudiantDto.nom());
    etudiant.setPrenom(etudiantDto.prenom());
    etudiant.setGenre(Genre.valueOf(etudiantDto.genre()));
    Centre centre = centreRepository.findById(etudiantDto.idCentre()).orElse(null);
    if (centre == null) {
        return null;
    }
    etudiant.setCentre(centre);
    etudiantRepository.save(etudiant);

    return etudiant;

}

//delete etudiant
@MutationMapping()
public String deleteEtudiant(@Argument Long id) {
    Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
    if (etudiant == null) {
        return "Etudiant not found";
    }
    etudiantRepository.delete(etudiant);

    return "Etudiant deleted";}

}



