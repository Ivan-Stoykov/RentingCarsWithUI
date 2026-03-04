package bg.tu_varna.sit.kolipodnaem.entities.Vid;

import bg.tu_varna.sit.kolipodnaem.entities.Specifications.Specification;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "vid")
@Data
public class Vid {
    @Id
    @Column(name = "vid_id")
    private int vid_id;
    @Column(name = "vid")
    private String vid;

    @OneToMany(mappedBy = "vid")
    private List<Specification> specifications;

}

