package org.jee.tpspringdata.utils;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.dtos.EtudiantDto;
import org.jee.tpspringdata.dtos.CentreDto;
import org.jee.tpspringdata.enums.Genre;
import org.jee.tpspringdata.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

// src/main/java/org/jee/tpspringdata/utils/ToEntities.java
@Component
public class ToEntities {

    @Autowired
    private CentreService centreService;

    public Etudiant dtoToEtudiant(EtudiantDto etudiantDto) {
        Optional<Centre> e = centreService.findById(etudiantDto.idCentre());
        if (e.isPresent()) {
            Genre genre = etudiantDto.genre() != null ? Genre.valueOf(etudiantDto.genre()) : null;
            return new Etudiant(etudiantDto.nom(), etudiantDto.prenom(), genre, e.get());
        }
        return null;
    }

    public Centre dtoToCentre(CentreDto centreDto) {
        return new Centre(centreDto.nom(), centreDto.adresse());
    }
}