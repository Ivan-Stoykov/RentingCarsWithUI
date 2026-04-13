package bg.tu_varna.sit.kolipodnaem.entities.zaemi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Table(name = "zaemi")
@Getter
@Setter
@NoArgsConstructor
@Immutable
public class ZaemiView {
    @Id
    private int zaem_id;

    @Column(name = "marka_name")
    private String marka_name;
    @Column(name = "kolamodel")
    private String kolamodel;
    @Column(name = "vid")
    private String vid;
    @Column(name = "godina")
    private int godina;
    @Column(name = "cvqt")
    private String cvqt;
    @Column(name = "ime_extra")
    private String ime_extra;
    @Column(name = "cena_za_den")
    private double cena_za_den;
    @Column(name = "datazaemane")
    private LocalDateTime datazaemane;
    @Column(name = "broidni")
    private int broidni;
    @Column(name = "datavrushtane")
    private LocalDateTime datavrushtane;
    @Column(name = "klient")
    private String klient;
    @Column(name = "izminatikilometri")
    private int izminatikilometri;
    @Column(name = "img_url")
    private String img_url;
    @Column(name = "klient_ID")
    private int klient_ID;
    @Column(name = "avtomobil_id")
    private int avtomobil_id;
    @Column(name = "email")
    private String email;
}
