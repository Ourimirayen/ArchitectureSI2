package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.*;
import com.esprit.gestionfoyer.repositories.BlocRepository;
import com.esprit.gestionfoyer.repositories.ChambreRepository;
import com.esprit.gestionfoyer.repositories.EtudiantRepository;
import com.esprit.gestionfoyer.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
    BlocRepository blocRepository;
    EtudiantRepository etudiantRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    @Transactional
    public Reservation addReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (bloc == null || etudiant == null) {
            return null;
        }

        Chambre chambre = bloc.getChambres().stream()
                .filter(c -> c.getReservations().stream().noneMatch(Reservation::isEstValide))
                .findFirst()
                .orElse(null);

        if (chambre == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        String idReservation = chambre.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + calendar.get(Calendar.YEAR);

        Reservation reservation = new Reservation();
        reservation.setIdReservation(idReservation);
        reservation.setAnneeUniversitaire(new Date());
        reservation.setEstValide(true);
        reservation.setChambre(chambre);

        List<Etudiant> etudiants = List.of(etudiant);
        reservation.setEtudiants(etudiants);

        chambre.getReservations().add(reservation);
        etudiant.getReservations().add(reservation);

        reservationRepository.save(reservation);
        chambreRepository.save(chambre);
        etudiantRepository.save(etudiant);


        return reservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            return null;
        }

        Reservation reservation = etudiant.getReservations().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);

        if (reservation == null) {
            return null;
        }

        reservation.setEstValide(false);

        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            chambreRepository.save(chambre);
        }


        etudiant.getReservations().remove(reservation);
        etudiantRepository.save(etudiant);

        reservation.setChambre(null);
        reservation.getEtudiants().remove(etudiant);

        reservationRepository.save(reservation);


        return reservation;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getAnneeUniversitaire().getYear() == anneeUniversite.getYear() &&
                        reservation.getChambre().getBloc().getFoyer().getUniversite().getNomUniversite().equals(nomUniversite))
                .toList();
    }
}