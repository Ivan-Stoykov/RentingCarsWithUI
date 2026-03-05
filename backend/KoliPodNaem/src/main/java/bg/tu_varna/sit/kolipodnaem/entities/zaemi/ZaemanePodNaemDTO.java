package bg.tu_varna.sit.kolipodnaem.entities.zaemi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ZaemanePodNaemDTO {
    private int Id;
    private String klientName;
    private String slujitelName;
    private String avtomobilMarka;
    private String avtomobilModel;
    private LocalDateTime dataZaemane;
    private LocalDateTime dataVrushtane;
    private int broiDni;
}
