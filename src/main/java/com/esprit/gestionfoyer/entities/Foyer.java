package com.esprit.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Foyer")
public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFoyer")
    private long idFoyer;

    @Column(name="nomFoyer")
    private String nomFoyer;

    @Column(name="capaciteFoyer")
    private long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}