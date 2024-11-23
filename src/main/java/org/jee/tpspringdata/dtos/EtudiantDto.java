package org.jee.tpspringdata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jee.tpspringdata.enums.Genre;

public record  EtudiantDto (
      String nom,
   String prenom,
     String genre,
     Long idCentre




      ) {   }
