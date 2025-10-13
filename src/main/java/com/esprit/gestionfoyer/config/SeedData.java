package com.esprit.gestionfoyer.config;

import com.esprit.gestionfoyer.entities.*;
import com.esprit.gestionfoyer.services.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class SeedData implements CommandLineRunner {

    private final IUniversiteService universiteService;
    private final IFoyerService foyerService;
    private final IBlocService blocService;
    private final IChambreService chambreService;
    private final IEtudiantService etudiantService;
    private final IReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {
        // Seed Universities
        Universite u1 = universiteService.addUniversite(new Universite(0, "ESPRIT", "Ghazela", null));
        Universite u2 = universiteService.addUniversite(new Universite(0, "SESAME", "Technopole", null));

        // Seed Foyers
        Foyer f1 = foyerService.addFoyer(new Foyer(0, "Foyer Esprit", 100, null, null));
        Foyer f2 = foyerService.addFoyer(new Foyer(0, "Foyer SESAME", 80, null, null));

        // Associate Foyers with Universities
        universiteService.affecterFoyerAUniversite(f1.getIdFoyer(), u1.getNomUniversite());
        universiteService.affecterFoyerAUniversite(f2.getIdFoyer(), u2.getNomUniversite());

        // Seed Blocs
        Bloc b1 = blocService.addBloc(new Bloc(0, "Bloc A", 50, f1, null));
        Bloc b2 = blocService.addBloc(new Bloc(0, "Bloc B", 50, f1, null));

        // Seed Chambres
        Chambre c1 = chambreService.addChambre(new Chambre(0, 101, TypeChambre.SIMPLE, b1, null));
        Chambre c2 = chambreService.addChambre(new Chambre(0, 102, TypeChambre.DOUBLE, b1, null));
        Chambre c3 = chambreService.addChambre(new Chambre(0, 201, TypeChambre.TRIPLE, b2, null));

        // Seed Etudiants
        Etudiant e1 = etudiantService.addEtudiants(List.of(new Etudiant(0, "Doe", "John", 12345678, "ESPRIT", new Date(), null))).get(0);
        Etudiant e2 = etudiantService.addEtudiants(List.of(new Etudiant(0, "Smith", "Jane", 87654321, "SESAME", new Date(), null))).get(0);

        // Add a reservation
        reservationService.addReservation(b1.getIdBloc(), e1.getCin());
    }
}