package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.Chambre;
import com.esprit.gestionfoyer.entities.TypeChambre;
import com.esprit.gestionfoyer.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findAll().stream().filter(chambre -> chambre.getBloc().getFoyer().getUniversite().getNomUniversite().equals(nomUniversite)).toList();
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre type) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc, type);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.findAll().stream()
                .filter(chambre -> chambre.getBloc().getFoyer().getUniversite().getNomUniversite().equals(nomUniversite) &&
                        chambre.getTypeC() == type &&
                        chambre.getReservations().stream().noneMatch(reservation -> reservation.isEstValide()))
                .toList();
    }
}