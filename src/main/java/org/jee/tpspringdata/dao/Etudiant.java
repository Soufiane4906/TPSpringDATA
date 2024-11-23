package org.jee.tpspringdata.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jee.tpspringdata.enums.Genre;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "students")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nomEtudiant" , nullable = false)
    private String nom;
    @Column(name = "prenomEtudiant")
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "centre_id" , nullable = false)
    private Centre centre;


    public Etudiant(String nom, String prenom, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
    }

    public Etudiant(String nom, String prenom, Genre genre, Centre centre) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.centre = centre;
    }
}
