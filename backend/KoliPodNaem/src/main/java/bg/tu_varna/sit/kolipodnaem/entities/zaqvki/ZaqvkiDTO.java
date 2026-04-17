package bg.tu_varna.sit.kolipodnaem.entities.zaqvki;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilViewDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ZaqvkiDTO {
    private int Id;
    private int klient_ID;
    private String klient;
    private String email;
    private LocalDateTime dataZaemane;
    private LocalDateTime dataVrushtane;
    private Integer broiDni;
    private AvtomobilViewDTO car;
}
