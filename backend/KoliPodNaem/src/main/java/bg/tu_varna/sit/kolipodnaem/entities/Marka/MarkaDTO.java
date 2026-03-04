package bg.tu_varna.sit.kolipodnaem.entities.Marka;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MarkaDTO {
    private int id;
    private String marka;
    private List<KolaModelDTOForMarka> kolamodel;
}
