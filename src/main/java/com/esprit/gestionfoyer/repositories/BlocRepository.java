package com.esprit.gestionfoyer.repositories;

import com.esprit.gestionfoyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
}