package com.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Reservation")
public class Reservation implements Serializable {

    @Id
    @Column(name="idReservation")
    private String idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    @Column(name="estValide")
    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToMany
    @JoinTable(name = "reservation_etudiant",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;
}