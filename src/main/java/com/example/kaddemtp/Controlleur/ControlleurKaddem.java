package com.example.kaddemtp.Controlleur;

import com.example.kaddemtp.Entity.Departement;
import com.example.kaddemtp.Entity.Etudiant;
import com.example.kaddemtp.Service.IserviceKaddem;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Kaddem")
public class ControlleurKaddem {

IserviceKaddem kaddemserv;

    @PostMapping("/asseignEtudiantToEquipe/{idEtudiant}/{idEquipe}")
    @ResponseBody
    public ResponseEntity<String> asseignEtudiantToEquipe(
            @PathVariable("idEtudiant") Integer idEtudiant,
            @PathVariable("idEquipe") Integer idEquipe) {
        kaddemserv.asseignEtudiantToEquipe(idEtudiant, idEquipe);
        return ResponseEntity.ok("Opération réussie");
    }

    @PostMapping("/asseignEtudiantDepartement/{etudiantid}/{departementid}")
    @ResponseBody
    public ResponseEntity<String> asseignEtudiantDepartement(
            @PathVariable("etudiantid") Integer etudiantid,
            @PathVariable("departementid") Integer departementid) {
        kaddemserv.asseignEtudiantDepartement(etudiantid,departementid);
        return ResponseEntity.ok("Opération réussie");
    }

    @PostMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    @ResponseBody
    public ResponseEntity<String> assignUniversiteToDepartement(
            @PathVariable("idUniversite") Integer idUniversite,
            @PathVariable("idDepartement") Integer idDepartement) {
        kaddemserv.assignUniversiteToDepartement(idUniversite,idDepartement);
        return ResponseEntity.ok("Opération réussie");
    }

    @GetMapping("getEtudiantsByDepartement/{idDepartement}")
    public ResponseEntity<List<Etudiant>> getEtudiantsByDepartement(@PathVariable Integer idDepartement) {
        List<Etudiant> etudiants = kaddemserv.getEtudiantsByDepartement(idDepartement);
        if (etudiants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/getDepartementsByUniversite/{idUniversite}")
    public ResponseEntity<List<Departement>> getDepartementsByUniversite(@PathVariable Integer idUniversite) {
        List<Departement> departements = kaddemserv.retrieveDepartementsByUniversite(idUniversite);
        return ResponseEntity.ok(departements);
    }
}
