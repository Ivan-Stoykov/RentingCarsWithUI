package bg.tu_varna.sit.kolipodnaem.entities.Klienti;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KlientDTO {
    private int klient_ID;
    private String ime;
    private String telefon;
    private String email;
    private AddressDTO address;
    private String rolq;
}
