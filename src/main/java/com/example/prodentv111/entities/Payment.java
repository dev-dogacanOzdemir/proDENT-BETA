package com.example.prodentv111.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "odemeler")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long musteriKasaID;
    private String musteriKasaTc;
    private String musteriKasaAd;
    private String musteriKasaSoyad;
    private String musteriKasaTelefon;
    private String musteriKasaBorc;

}
