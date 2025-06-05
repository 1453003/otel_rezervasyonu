package com.example.rezervasyon.repository;

import com.example.rezervasyon.model.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervasyonRepository extends JpaRepository<Rezervasyon, Long> {
}

