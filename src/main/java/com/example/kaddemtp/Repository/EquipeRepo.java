package com.example.kaddemtp.Repository;

import com.example.kaddemtp.Entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepo  extends JpaRepository<Equipe,Integer> {
    Equipe findByIdEquipe( Integer idEquipe);
}
