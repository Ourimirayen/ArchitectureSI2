package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.Chambre;
import com.esprit.gestionfoyer.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SchedulerService {
    ChambreRepository chambreRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void afficherChambresNonReservees() {
        List<Chambre> chambresNonReservees = chambreRepository.findAll().stream()
                .filter(chambre -> chambre.getReservations().stream().noneMatch(reservation -> reservation.isEstValide()))
                .toList();
        log.info("Chambres non réservées: " + chambresNonReservees.size());
        chambresNonReservees.forEach(chambre -> log.info("Chambre: " + chambre.getIdChambre()));
    }
}