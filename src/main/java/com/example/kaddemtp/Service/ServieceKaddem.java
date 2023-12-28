package com.example.kaddemtp.Service;

import com.example.kaddemtp.Entity.*;
import com.example.kaddemtp.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ServieceKaddem  implements IserviceKaddem{
    @Autowired
    ContartRepo contatrepo;
DepartementRepo depart;
DetailEquipeRepo detailequipe;
EquipeRepo equipero;
EtudiantRepo etudiantrepo;
UniversityRepo universierepo;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantrepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e, Option o) {
         e.setOptions(o);
         return etudiantrepo.save(e);
    }

    @Override
    public Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d) {
        e.setOptions(o);
        e.setDepartement(d);
        return etudiantrepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantrepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantrepo.findById( idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
etudiantrepo.deleteById(idEtudiant);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contatrepo.findAll();
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contatrepo.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contatrepo.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contatrepo.findById(idContrat).get();
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contatrepo.deleteById(idContrat);
    }

    @Override
    public List<Departement> retrieveAllDepartements() {
        return depart.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return depart.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return depart.save(d);
    }

    @Override
    public Departement retreiveDepartement(Integer idDepart) {
        return depart.findById(idDepart).get();
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipero.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipero.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipero.save(e);
    }

    @Override
    public Equipe retreiveEquipe(Integer idEquipe) {

        return equipero.findById(idEquipe).get();
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
equipero.deleteById(idEquipe);
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universierepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universierepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universierepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniv) {
        return universierepo.findById(idUniv).get();
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
universierepo.deleteById(idUniversite);
    }

    @Override
    public void asseignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe) {
        Etudiant et = etudiantrepo.findById(idEtudiant).orElse(null);
        Equipe eq = equipero.findById(idEquipe).orElse(null);

        if (et != null && eq != null) {
            // Liste des étudiants de l'équipe
            Set<Etudiant> etudiantsEquipe = eq.getEtudiantsequipe();

            // Initialiser la liste si elle est nulle
            if (etudiantsEquipe == null) {
                etudiantsEquipe = new HashSet<>();
            }

            // Ajouter l'étudiant à la liste
            etudiantsEquipe.add(et);

            // Mettre à jour la liste des étudiants de l'équipe
            eq.setEtudiantsequipe(etudiantsEquipe);

            // Mettre à jour l'équipe dans la base de données
            equipero.save(eq);
        }
    }

    @Override
    public void asseignEtudiantDepartement(Integer etudiantid, Integer departementid) {
    Etudiant etudiant = etudiantrepo.findById(etudiantid).get();
    Departement departement = depart.findById(departementid).get();
      etudiant.setDepartement(departement);
      etudiantrepo.save(etudiant);

    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        // Récupération de l'Université et du Département
        Universite univer = universierepo.findById(idUniversite).orElse(null);
        Departement dep =depart.findById(idDepartement).orElse(null);
        // Vérification si la liste des départements est null
        if(univer.getDepartementsUniversitaire()==null){
            Set<Departement>departset = new HashSet<>();
            departset.add(dep);
            univer.setDepartementsUniversitaire(departset); //affectaion
        }
         // Ajout du Département à la liste existante
        else {
            univer.getDepartementsUniversitaire().add(dep);

        }
        universierepo.save(univer);

    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return  etudiantrepo.findEtudiantByDepartement_IdDepart(idDepartement);

    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idDepartement) {
        return depart.retrieveDepartementsByUniversite(idDepartement);
    }
}
