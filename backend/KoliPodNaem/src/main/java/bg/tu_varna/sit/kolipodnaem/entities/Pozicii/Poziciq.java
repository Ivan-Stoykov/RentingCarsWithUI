package bg.tu_varna.sit.kolipodnaem.entities.Pozicii;

import bg.tu_varna.sit.kolipodnaem.entities.Slujiteli.Slujitel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "pozicii")
public class Poziciq {
    @Id
    @Column(name = "POZICIQ_ID")
    private int poziciq_ID;

    @Column(name = "POZICIQ")
    private String poziciq;

    @OneToMany(mappedBy = "poziciq")
    private List<Slujitel> slujiteli;
}
