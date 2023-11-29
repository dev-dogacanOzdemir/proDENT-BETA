package com.example.prodentv111.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name="musteriler")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musteriID;
    private String musteriTc;
    private String musteriAd;
    private String musteriSoyad;
    private String musteriAdres;
    private String musteriTelefon;
    private String musteriDogumTarihi;
    private char musteriCinsiyet;
    private String musteriKanGrubu;
}