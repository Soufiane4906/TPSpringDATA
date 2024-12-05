package org.jee.tpspringdata.controllers;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.jee.tpspringdata.dtos.EtudiantDto;
import org.jee.tpspringdata.enums.Genre;
import org.jee.tpspringdata.service.CentreService;
import org.jee.tpspringdata.service.EtudiantService;
import org.jee.tpspringdata.utils.ToEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class EtudiantController {
    @Autowired
    private CentreService centreService;

    @Autowired
    private EtudiantService etudiantService;


    @QueryMapping()
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }



    @QueryMapping()
    public Etudiant getEtudiant(@Argument Long id) {
        return etudiantService.getEtudiant(id);
    }

    @MutationMapping()
    public Etudiant addEtudiant(@Argument EtudiantDto etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @MutationMapping()
    public Etudiant updateEtudiant(@Argument Long id, @Argument EtudiantDto etudiantDto) {
        return etudiantService.updateEtudiant(id, etudiantDto);
    }

    @SubscriptionMapping
    public Flux<Etudiant> etudiantAdded() {
        return etudiantService.getEtudiantAddedPublisher();
    }

    @MutationMapping()
    public String deleteEtudiant(@Argument Long id) {
        Etudiant etudiant = etudiantService.deleteEtudiant(id);
        return etudiant == null ? "Etudiant not found" : "Etudiant deleted";
    }
}