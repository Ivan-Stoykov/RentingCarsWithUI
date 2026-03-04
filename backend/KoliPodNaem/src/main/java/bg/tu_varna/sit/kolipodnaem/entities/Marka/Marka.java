package bg.tu_varna.sit.kolipodnaem.entities.Marka;

import bg.tu_varna.sit.kolipodnaem.entities.KolaModel.KolaModel;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "Marka")
public class Marka {
    @Id
    @Column(name = "marka_id")
    private int id;
    @Column(name = "marka_name")
    private String marka;

    @OneToMany(mappedBy = "marka")
    private List<KolaModel> kolamodels;
}
