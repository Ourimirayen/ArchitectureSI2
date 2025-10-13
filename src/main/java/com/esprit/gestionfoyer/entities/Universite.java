package com.esprit.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Universite")
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private long idUniversite;

    @Column(name="nomUniversite", unique = true)
    private String nomUniversite;

    @Column(name="adresse")
    private String adresse;

    @OneToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;
}