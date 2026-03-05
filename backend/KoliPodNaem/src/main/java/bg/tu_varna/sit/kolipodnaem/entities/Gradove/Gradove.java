package bg.tu_varna.sit.kolipodnaem.entities.Gradove;

import bg.tu_varna.sit.kolipodnaem.entities.Durjavi.Durjavi;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.Klient;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "gradove")
public class Gradove {
    @Id
    @Column(name = "GRAD_ID")
    private int grad_id;
    @Column(name = "GRAD")
    private String grad;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "durjava_ID")
    private Durjavi durjavi;

    @OneToMany(mappedBy = "grad")
    private List<Klient> klienti;
}
