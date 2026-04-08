package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import bg.tu_varna.sit.kolipodnaem.entities.Specifications.SpecificationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvtomobilPostDTO {
    private String marka;
    private String model;
    private String vid;
    private int godina;
    private String cvqt;
    private String ekstri;
    private double cenaZaDen;
    private int izminatiKilometri;
    private String img_url;
}
