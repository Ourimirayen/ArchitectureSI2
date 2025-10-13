package com.esprit.gestionfoyer.repositories;

import com.esprit.gestionfoyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByCin(long cin);
}