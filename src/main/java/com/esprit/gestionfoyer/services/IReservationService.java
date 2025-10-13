package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation(Reservation res);

    Reservation retrieveReservation(String idReservation);

    Reservation addReservation(long idBloc, long cinEtudiant);

    Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
}