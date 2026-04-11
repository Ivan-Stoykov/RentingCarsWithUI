package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Table(name = "avtomobilview")
@Getter
@Setter
@NoArgsConstructor
@Immutable
public class AvtomobilView {
    @Id
    private int avtomobil_id;

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
    @Column(name = "IZMINATIKILOMETRI")
    private int izminatikilometri;
    @Column(name = "img_url")
    private String img_url;
}
