package com.example.kaddemtp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Detailequipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer Iddetailequipe;
    Long salle;
    String thematique;
@OneToOne
    Equipe equipe;


}
