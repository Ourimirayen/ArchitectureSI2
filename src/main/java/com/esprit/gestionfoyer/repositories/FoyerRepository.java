package com.esprit.gestionfoyer.repositories;

import com.esprit.gestionfoyer.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}