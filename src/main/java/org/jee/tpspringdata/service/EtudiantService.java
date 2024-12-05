package org.jee.tpspringdata.service;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.dtos.EtudiantDto;
import org.jee.tpspringdata.enums.Genre;
import org.jee.tpspringdata.repositories.CentreRestRepository;
import org.jee.tpspringdata.repositories.EtudiantRestRepository;
import org.jee.tpspringdata.utils.ToEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRestRepository etudiantRepository;

    @Autowired
    private CentreRestRepository centreRestRepository;

    @Autowired
    private ToEntities toEntities;

    private final Sinks.Many<Etudiant> sink = Sinks.many().multicast().onBackpressureBuffer();

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant addEtudiant(EtudiantDto etudiant) {
        Centre centre=centreRestRepository.findById(etudiant.idCentre()).orElse(null);
        if(centre!=null){
            Etudiant et=new Etudiant();
            et.setNom(etudiant.nom());
            et.setPrenom(etudiant.prenom());
            if (etudiant.genre() != null) {
                et.setGenre(Genre.valueOf(etudiant.genre()));
            } else {
                et.setGenre(null); // or handle the null case as needed
            }

            et.setCentre(centre);
            sink.tryEmitNext(et);
            etudiantRepository.save(et);
            sink.tryEmitNext(et);
            return et;
        }
        return null;
    }




    public Etudiant updateEtudiant(Long id, EtudiantDto etudiantDto) {
        Etudiant etudiantToUpdate = etudiantRepository.findById(id).orElse(null);
        if (etudiantToUpdate == null) {
            return null;
        }
        Etudiant etudiantUpdated = toEntities.dtoToEtudiant(etudiantDto);
        return etudiantRepository.save(etudiantUpdated);
    }

    public Etudiant deleteEtudiant(Long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant == null) {
            return null;
        }
        etudiantRepository.delete(etudiant);
        return etudiant;
    }

    public Flux<Etudiant> getEtudiantAddedPublisher() {
        return sink.asFlux();
    }
}