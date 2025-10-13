package com.esprit.gestionfoyer.repositories;

import com.esprit.gestionfoyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}