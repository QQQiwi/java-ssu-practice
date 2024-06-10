package com.example.service;

import com.example.model.Tarif;
import com.example.repository.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TarifService {

    @Autowired
    private TarifRepository tarifRepository;

    public List<Tarif> getAllTarifs() {
        return tarifRepository.findAll();
    }

    public Optional<Tarif> getTarifById(Long id) {
        return tarifRepository.findById(id);
    }

    public Tarif createTarif(Tarif tarif) {
        return tarifRepository.save(tarif);
    }

    public Tarif updateTarif(Long id, Double rate, LocalDateTime lastModified) {
        Optional<Tarif> optionalTarif = tarifRepository.findById(id);
        if (optionalTarif.isPresent()) {
            Tarif tarif = optionalTarif.get();
            tarif.setRate(rate);
            tarif.setLastModified(lastModified);
            return tarifRepository.save(tarif);
        }
        return null;
    }

    public boolean deleteTarif(Long id) {
        if (!tarifRepository.existsById(id)) {
            return false;
        }
        tarifRepository.deleteById(id);
        return true;
    }
}
