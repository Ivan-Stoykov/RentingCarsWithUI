package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvtomobilUpdateDTO {
    private int id;
    private int cvqt;
    private int spec;
    private int izminatiKilometri;
}
