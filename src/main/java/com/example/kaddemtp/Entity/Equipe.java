package com.example.kaddemtp.Entity;

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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEquipe;
    String nomEquipe ;

    @Enumerated(EnumType.STRING)
    Niveau niveau ;

    @ManyToMany
    Set<Etudiant> Etudiantsequipe;

    @OneToOne(mappedBy = "equipe")
Detailequipe detailsequipe;
}
