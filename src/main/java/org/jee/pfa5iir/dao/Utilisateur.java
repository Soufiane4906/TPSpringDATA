package org.jee.pfa5iir.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jee.pfa5iir.enums.Role;
import org.jee.tpspringdata.enums.Genre;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @JsonIgnore
    private String motDePasse;

    private Date dateInscription;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN, CLIENT, ARTISAN
}
