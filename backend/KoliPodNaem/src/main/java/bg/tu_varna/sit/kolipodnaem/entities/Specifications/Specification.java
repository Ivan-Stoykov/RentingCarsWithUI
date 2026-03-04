package bg.tu_varna.sit.kolipodnaem.entities.Specifications;

import bg.tu_varna.sit.kolipodnaem.entities.KolaModel.KolaModel;
import bg.tu_varna.sit.kolipodnaem.entities.Vid.Vid;
import bg.tu_varna.sit.kolipodnaem.entities.ekstri.Ekstri;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "specifikacii")
@Data
public class Specification {
    @Id
    private int spec_ID;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_id")
    private KolaModel kolamodel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vid_id")
    private Vid vid;

    @Column(name = "godina")
    private int godina;

    @Column(name = "cenaZaDen")
    private double cenaZaDen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ekstri_id")
    private Ekstri ekstri;


}
