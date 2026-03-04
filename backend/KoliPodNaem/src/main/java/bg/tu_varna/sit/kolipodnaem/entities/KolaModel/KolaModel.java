package bg.tu_varna.sit.kolipodnaem.entities.KolaModel;

import bg.tu_varna.sit.kolipodnaem.entities.Marka.Marka;
import bg.tu_varna.sit.kolipodnaem.entities.Specifications.Specification;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToMany(mappedBy = "kolamodel")
    private List<Specification> specifications;
}
