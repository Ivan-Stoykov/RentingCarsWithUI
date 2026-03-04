package bg.tu_varna.sit.kolipodnaem.entities.ekstri;

import bg.tu_varna.sit.kolipodnaem.entities.Specifications.Specification;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ekstri")
@Data
public class Ekstri {
    @Id
    @Column(name = "extra_Id")
    private int extraId;
    @Column(name = "ime_extra")
    private String imeExtra;

    @OneToMany(mappedBy = "ekstri")
    private List<Specification> specifications;
}
