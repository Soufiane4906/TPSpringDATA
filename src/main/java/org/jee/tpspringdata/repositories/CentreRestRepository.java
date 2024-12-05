package org.jee.tpspringdata.repositories;

import org.jee.tpspringdata.dao.Centre;
import org.jee.tpspringdata.dao.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "centres")
public interface CentreRestRepository extends JpaRepository<Centre, Long> {
    public Centre findCentreById(Long Id);



}
