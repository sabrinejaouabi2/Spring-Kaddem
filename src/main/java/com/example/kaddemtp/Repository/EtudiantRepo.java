package com.example.kaddemtp.Repository;

import com.example.kaddemtp.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepo extends JpaRepository<Etudiant,Integer> {


   @Query("select e from Etudiant  e where e.departement.idDepart =: department")
   List<Etudiant> getEtudiantbydepartment(@Param("department ") Integer idDepart);

   List<Etudiant>  findEtudiantByDepartement_IdDepart(Integer idDepart);
}
