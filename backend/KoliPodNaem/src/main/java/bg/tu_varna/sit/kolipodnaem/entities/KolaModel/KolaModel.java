package bg.tu_varna.sit.kolipodnaem.entities.KolaModel;

import bg.tu_varna.sit.kolipodnaem.entities.Marka.Marka;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "kolamodel")
public class KolaModel {
    @Id
    @Column(name = "model_id")
    private int id;
    @Column(name = "kolamodel")
    private String kolamodel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "marka_id")
    private Marka marka;
}
