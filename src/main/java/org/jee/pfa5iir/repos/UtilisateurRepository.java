package org.jee.pfa5iir.repos;

import org.jee.pfa5iir.dao.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "utilisateurs")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> { }