package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import bg.tu_varna.sit.kolipodnaem.entities.Specifications.SpecificationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvtomobilDTO {
    private int id;
    private String cvqt;
    private int izminatiKilometri;
    private SpecificationDTO specs;
}
