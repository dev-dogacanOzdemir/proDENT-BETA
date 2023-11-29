package com.example.prodentv111.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "randevular")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long randevuID;
    public String randevuTc;
    public String randevuİsim;
    public String randevuSoyisim;
    public String randevuTarih;
    public String randevuSaat;

}
