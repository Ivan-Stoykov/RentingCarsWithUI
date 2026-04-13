package bg.tu_varna.sit.kolipodnaem.entities.Avtomobil;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvtomobilViewDTO {
    private int avtomobil_id;
    private String marka_name;
    private String kolamodel;
    private String vid;
    private int godina;
    private String cvqt;
    private String ime_extra;
    private double cena_za_den;
    private int izminatikilometri;
    private String img_url;
}
