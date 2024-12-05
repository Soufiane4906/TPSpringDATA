package org.jee.tpspringdata.service;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.repositories.CentreRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreService {

    @Autowired
    private CentreRestRepository centreRepository;

    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }
    public Centre getCentre(Long id) {
        return centreRepository.findById(id).orElse(null);
    }
    public Centre addCentre(Centre centre) {
        return centreRepository.save(centre);
    }
    public Centre updateCentre(Long id, Centre centre) {
        Centre centreToUpdate = centreRepository.findById(id).orElse(null);
        if (centreToUpdate == null) {
            return null;
        }
        centreToUpdate.setNom(centre.getNom());
        centreToUpdate.setAdresse(centre.getAdresse());
        return centreRepository.save(centreToUpdate);
    }

    //delte centre
    public Centre deleteCentre(Long id) {
        Centre centreToDelete = centreRepository.findById(id).orElse(null);
        if (centreToDelete == null) {
            return null;
        }
        centreRepository.delete(centreToDelete);
        return centreToDelete;
    }


    public Optional<Centre> findById(Long aLong) {
        return centreRepository.findById(aLong);
    }
}
