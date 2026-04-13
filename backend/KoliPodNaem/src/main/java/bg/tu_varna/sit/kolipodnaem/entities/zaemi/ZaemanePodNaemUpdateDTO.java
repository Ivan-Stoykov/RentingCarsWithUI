package bg.tu_varna.sit.kolipodnaem.entities.zaemi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ZaemanePodNaemUpdateDTO {
    private int Id;
    private int avtomobil_id;
    private int klient_ID;
    private LocalDate dataZaemane;
    private LocalDate dataVrushtane;
    private int broiDni;
}
