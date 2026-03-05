package bg.tu_varna.sit.kolipodnaem.entities.Durjavi;

import bg.tu_varna.sit.kolipodnaem.entities.Gradove.Gradove;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "durjavi")
public class Durjavi {
    @Id
    @Column(name="durjava_ID")
    private int durjava_id;
    @Column(name = "durjava")
    private String durjava;
    @OneToMany(mappedBy = "durjavi")
    private List<Gradove> gradove;
}
