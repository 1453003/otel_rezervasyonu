package com.example.rezervasyon.model;

import jakarta.persistence.*;

@Entity
public class Rezervasyon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String musteriAdi;

    @ManyToOne
    private Otel otel;

    // Getter ve Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public Otel getOtel() {
        return otel;
    }

    public void setOtel(Otel otel) {
        this.otel = otel;
    }
}

