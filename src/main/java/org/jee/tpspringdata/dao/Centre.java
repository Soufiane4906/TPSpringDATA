package org.jee.tpspringdata.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jee.tpspringdata.enums.Genre;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "centres")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nomCentre" , nullable = false)
    private String nom;
    @Column(name = "adresseCentre")
    private String adresse;
    @OneToMany(mappedBy = "centre")
    private List<Etudiant> etudiants;


}
