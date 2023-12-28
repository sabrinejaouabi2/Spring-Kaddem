package com.example.kaddemtp.Repository;

import com.example.kaddemtp.Entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartementRepo extends JpaRepository<Departement,Integer> {
    @Query("SELECT d FROM Universite u JOIN u.departementsUniversitaire d WHERE u.idUniv = :idUniversite")
    List<Departement> retrieveDepartementsByUniversite(@Param("idUniversite") Integer idUniversite);
}
