package com.esprit.gestionfoyer.entities;

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
@Table( name = "Bloc")
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    private long idBloc;

    @Column(name="nomBloc")
    private String nomBloc;

    @Column(name="capaciteBloc")
    private long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;
}