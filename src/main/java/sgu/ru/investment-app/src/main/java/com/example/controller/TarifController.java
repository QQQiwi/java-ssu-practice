package com.example.controller;

import com.example.model.Tarif;
import com.example.service.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/tarifs")
public class TarifController {

    @Autowired
    private TarifService tarifService;

    @GetMapping
    public List<Tarif> getAllTarifs() {
        return tarifService.getAllTarifs();
    }

    @PostMapping
    public ResponseEntity<Tarif> createTarif(@RequestBody Tarif tarif) {
        tarif.setLastModified(LocalDateTime.now());
        Tarif createdTarif = tarifService.createTarif(tarif);
        return ResponseEntity.ok(createdTarif);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarif> getTarifById(@PathVariable Long id) {
        return tarifService.getTarifById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarif> updateTarif(@PathVariable Long id, @RequestParam Double rate, @RequestParam String lastModified) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(lastModified, formatter);
        Tarif updatedTarif = tarifService.updateTarif(id, rate, dateTime);
        return updatedTarif != null ? ResponseEntity.ok(updatedTarif) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTarif(@PathVariable Long id) {
        try {
            if (tarifService.deleteTarif(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            String errorMessage = "Невозможно удалить тариф так как существуют пользователи с этим тарифом!";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }
    }
}
