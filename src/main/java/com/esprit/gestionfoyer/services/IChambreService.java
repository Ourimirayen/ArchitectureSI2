package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.Chambre;
import com.esprit.gestionfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(long idChambre);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre type);

    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
}