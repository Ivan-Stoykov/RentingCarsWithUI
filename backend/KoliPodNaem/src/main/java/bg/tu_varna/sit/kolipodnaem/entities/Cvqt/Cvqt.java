package bg.tu_varna.sit.kolipodnaem.entities.Cvqt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Cvqt")
@Data
public class Cvqt {
    @Id
    @Column(name = "CVQT_ID")
    private int id;
    @Column(name = "Cvqt")
    private String cvqt;
}
