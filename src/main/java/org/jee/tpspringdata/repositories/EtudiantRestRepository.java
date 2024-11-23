package org.jee.tpspringdata.repositories;

import org.jee.tpspringdata.dao.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

//@RepositoryRestResource(path = "students")
public interface EtudiantRestRepository extends JpaRepository<Etudiant, Long> {
   // public Etudiant findEtudiantByNom(@Param("n") String nom);
    //public List<Etudiant> findEtudiantsByGenre(@Param("g") String genre);



}
