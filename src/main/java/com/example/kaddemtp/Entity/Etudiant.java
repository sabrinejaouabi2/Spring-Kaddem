package com.example.kaddemtp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer idEtudiant ;
    String prenomE ;
    String nomE;
    @Enumerated(EnumType.STRING)
    Option options;

    @OneToMany (mappedBy = "etudiant")
    Set <Contrat> contrats ;

    @JsonIgnore

    @ManyToOne
    Departement departement;
    @JsonIgnore
    @ManyToMany(mappedBy = "Etudiantsequipe")
    Set<Equipe> equipesEtudiants;

}
