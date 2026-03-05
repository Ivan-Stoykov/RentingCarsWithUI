package bg.tu_varna.sit.kolipodnaem.entities.Slujiteli;

import bg.tu_varna.sit.kolipodnaem.entities.Pozicii.Poziciq;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaem;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "slujitel")
public class Slujitel {
    @Id
    @Column(name = "SLUJITEL_ID")
    private int slujitel_ID;

    @Column(name = "IME")
    private String ime;

    @Column(name = "TELEFON")
    private String telefon;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "poziciq_id")
    private Poziciq poziciq;

    @OneToMany(mappedBy = "slujitel")
    private List<ZaemanePodNaem> zaemane;
}
