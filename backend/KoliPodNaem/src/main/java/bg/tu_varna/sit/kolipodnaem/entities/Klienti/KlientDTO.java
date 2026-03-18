package bg.tu_varna.sit.kolipodnaem.entities.Klienti;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KlientDTO {
    private int id;
    private String ime;
    private String telefon;
    private String ulica;
    private String grad;
    private String durjava;
}
