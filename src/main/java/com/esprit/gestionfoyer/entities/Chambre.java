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
@Table( name = "Chambre")
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private long idChambre;

    @Column(name="numeroChambre")
    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;
}