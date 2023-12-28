package com.example.kaddemtp.Service;

import com.example.kaddemtp.Entity.*;

import java.util.List;

public interface IserviceKaddem {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant e , Option o);
    Etudiant addAndAssignEtudiant (Etudiant e, Option o , Departement d);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    //Contart
    List<Contrat> retrieveAllContrats();

    Contrat addContrat (Contrat ce);
    Contrat updateContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);


//Departement
    List<Departement> retrieveAllDepartements();
    Departement addDepartement (Departement d);
            Departement updateDepartement (Departement d);
            Departement  retreiveDepartement (Integer idDepart);
//Equipe
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);

    Equipe retreiveEquipe(Integer idEquipe);
    void removeEquipe(Integer idEquipe);
//Universiter
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void removeUniversite (Integer idUniversite);

    void asseignEtudiantToEquipe(Integer idEtudiant , Integer idEquipe);
    public void asseignEtudiantDepartement(Integer etudiantid, Integer departementid) ;

    public void assignUniversiteToDepartement(Integer idUniversite,Integer idDepartement);

    List<Etudiant> getEtudiantsByDepartement(Integer idDepartement );

    public List<Departement> retrieveDepartementsByUniversite(Integer idDepartement);



}
