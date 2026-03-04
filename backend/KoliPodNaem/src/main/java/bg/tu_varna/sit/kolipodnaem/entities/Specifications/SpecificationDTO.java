package bg.tu_varna.sit.kolipodnaem.entities.Specifications;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpecificationDTO {
    private int spec_ID;
    private String modelName;
    private String vid;
    private String ekstri;
    private int godina;
    private double cenaZaDen;
}
