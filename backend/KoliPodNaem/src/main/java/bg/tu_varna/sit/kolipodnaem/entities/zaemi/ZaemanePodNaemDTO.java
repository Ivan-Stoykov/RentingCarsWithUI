package bg.tu_varna.sit.kolipodnaem.entities.zaemi;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ZaemanePodNaemDTO {
    private int Id;
    private String klientName;
    private String slujitelName;
    private LocalDateTime dataZaemane;
    private LocalDateTime dataVrushtane;
    private int broiDni;
    private AvtomobilDTO avtomobil;
}
