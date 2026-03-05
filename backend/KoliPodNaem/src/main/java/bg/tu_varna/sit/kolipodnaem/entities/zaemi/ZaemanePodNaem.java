package bg.tu_varna.sit.kolipodnaem.entities.zaemi;

import bg.tu_varna.sit.kolipodnaem.entities.Slujiteli.Slujitel;
import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.Avtomobil;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.Klient;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "zaemanepodnaem")
public class ZaemanePodNaem {
    @Id
    @Column(name = "ZAEM_ID")
    private int zaem_ID;

    @Column(name = "DATAZAEMANE")
    private LocalDateTime datazaemane;

    @Column(name = "DATAVRUSHTANE")
    private LocalDateTime datavrushtane;

    @Column(name = "BROIDNI")
    private int broidni;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "avtomobil_id")
    private Avtomobil avtomobil;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "klient_id")
    private Klient klient;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "slujitel_id")
    private Slujitel slujitel;


}
