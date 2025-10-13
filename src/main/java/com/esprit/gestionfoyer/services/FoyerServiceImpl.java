package com.esprit.gestionfoyer.services;

import com.esprit.gestionfoyer.entities.Bloc;
import com.esprit.gestionfoyer.entities.Foyer;
import com.esprit.gestionfoyer.repositories.BlocRepository;
import com.esprit.gestionfoyer.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer addFoyerWithBloc(Foyer foyer) {
        Foyer savedFoyer = foyerRepository.save(foyer);
        if (foyer.getBlocs() != null) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(savedFoyer);
                blocRepository.save(bloc);
            }
        }
        return savedFoyer;
    }
}