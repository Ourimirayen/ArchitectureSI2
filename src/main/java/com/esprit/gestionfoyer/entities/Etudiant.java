package com.esprit.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table( name = "Etudiant")
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private long idEtudiant;

    @Column(name="nomEt")
    private String nomEt;

    @Column(name="prenomEt")
    private String prenomEt;

    @Column(name="cin", unique = true)
    private long cin;

    @Column(name="ecole")
    private String ecole;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private List<Reservation> reservations;
}