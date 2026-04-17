package bg.tu_varna.sit.kolipodnaem.entities.zaqvki;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.Avtomobil;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.Klient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "zaqvki")
public class Zaqvki {
    @Id
    @Column(name = "ZAEM_ID")
    private int zaem_ID;

    @Column(name = "DATAZAEMANE")
    private LocalDateTime datazaemane;

    @Column(name = "DATAVRUSHTANE")
    private LocalDateTime datavrushtane;

    @Column(name = "BROIDNI")
    private int broidni;

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "avtomobil_id")
    private Avtomobil avtomobil;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "klient_id")
    private Klient klient;


}
