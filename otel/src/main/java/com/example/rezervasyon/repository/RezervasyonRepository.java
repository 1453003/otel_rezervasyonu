package com.example.rezervasyon.repository;

import com.example.rezervasyon.model.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RezervasyonRepository extends JpaRepository<Rezervasyon, Long> {
    List<Rezervasyon> findByMusteriAdi(String musteriAdi);
}

