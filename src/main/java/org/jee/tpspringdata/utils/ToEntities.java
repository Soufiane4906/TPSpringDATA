package org.jee.tpspringdata.utils;
import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.dtos.EtudiantDto;
import org.jee.tpspringdata.dtos.CentreDto;
import org.jee.tpspringdata.enums.Genre;

import static java.lang.String.valueOf;


public class ToEntities {
    public static Etudiant dtoToEtudiant(EtudiantDto etudiantDto) {
        return new Etudiant(etudiantDto.nom(), etudiantDto.prenom(), Genre.valueOf(etudiantDto.genre()), new Centre(etudiantDto.idCentre()));
    }


    public static Centre dtoToCentre(CentreDto centreDto) {
        return new Centre(centreDto.nom(), centreDto.adresse());
    }
}
