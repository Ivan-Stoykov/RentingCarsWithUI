package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import bg.tu_varna.sit.kolipodnaem.entities.Cvqt.Cvqt;
import bg.tu_varna.sit.kolipodnaem.entities.Specifications.Specification;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "avtomobil")
public class Avtomobil {
    @Id
    private int AvtomobilID;

    @Column(name = "IZMINATIKILOMETRI")
    private int IzminatiKilometri;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CVQT_ID")
    private Cvqt cvqt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "specId")
    private Specification specification;
}
