package org.jee.tpspringdata.utils;
import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.dtos.EtudiantDto;
import org.jee.tpspringdata.dtos.CentreDto;

public class ToDto {
    public static EtudiantDto etudiantToDto(Etudiant etudiant) {
        return new EtudiantDto(etudiant.getNom(), etudiant.getPrenom(), etudiant.getGenre().name(), etudiant.getCentre().getId());
    }

    public static CentreDto centreToDto(Centre centre) {
        return new CentreDto(centre.getNom(), centre.getAdresse());
    }
}
