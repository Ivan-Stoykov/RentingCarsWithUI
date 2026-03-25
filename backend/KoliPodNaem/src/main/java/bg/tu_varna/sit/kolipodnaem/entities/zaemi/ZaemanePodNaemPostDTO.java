package bg.tu_varna.sit.kolipodnaem.entities.zaemi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ZaemanePodNaemPostDTO {
    private int slujitel_id;
    private int klient_id;
    private int avtomobil_id;
    private LocalDateTime zaemane;
    private LocalDateTime vrushtane;
    private int broiDni;
}
