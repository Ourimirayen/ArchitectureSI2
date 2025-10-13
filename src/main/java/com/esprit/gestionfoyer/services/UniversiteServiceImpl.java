package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.Foyer;
import com.esprit.gestionfoyer.entities.Universite;
import com.esprit.gestionfoyer.repositories.FoyerRepository;
import com.esprit.gestionfoyer.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if(foyer != null && universite != null){
            universite.setFoyer(foyer);
            universiteRepository.save(universite);
            return universite;
        }
        return null;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if(universite != null){
            universite.setFoyer(null);
            universiteRepository.save(universite);
            return universite;
        }
        return null;
    }
}