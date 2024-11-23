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
public class CentreController {
    @Autowired
    private CentreRestRepository centreRepository;

    @Autowired
    private EtudiantRestRepository etudiantRepository;


    @QueryMapping()
    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }


    @QueryMapping()
    public Centre getCentre(@Argument Long id) {
        return centreRepository.findById(id).orElse(null);
    }

    @MutationMapping()
    public Centre addCentre(@Argument CentreDto centre) {
        Centre newCentre = new Centre(centre.nom(), centre.adresse());
        return centreRepository.save(newCentre);
    }

    @MutationMapping()
    public Centre updateCentre(@Argument Long id, @Argument CentreDto centreDto) {
        Centre centre = centreRepository.findById(id).orElse(null);
        if (centre == null) {
            return null;
        }
        centre.setNom(centreDto.nom());
        centre.setAdresse(centreDto.adresse());
        return centreRepository.save(centre);
    }
    @MutationMapping()
    public Centre deleteCentre(@Argument Long id) {
        Centre centre = centreRepository.findById(id).orElse(null);
        if (centre == null) {
            return null;
        }
        centreRepository.delete(centre);
        return centre;
    }


}



