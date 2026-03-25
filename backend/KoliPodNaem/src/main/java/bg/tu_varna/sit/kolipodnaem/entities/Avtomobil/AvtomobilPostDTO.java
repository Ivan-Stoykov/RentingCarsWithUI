package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import bg.tu_varna.sit.kolipodnaem.entities.Specifications.SpecificationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvtomobilPostDTO {
    private int id;
    private int marka;
    private int model;
    private int vid;
    private int godina;
    private int cvqt;
    private String ekstri;
    private double cenaZaDen;
    private int izminatiKilometri;
}
