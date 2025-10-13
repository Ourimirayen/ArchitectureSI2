package com.esprit.gestionfoyer.repositories;

import com.esprit.gestionfoyer.entities.Chambre;
import com.esprit.gestionfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);
}