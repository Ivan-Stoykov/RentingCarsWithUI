package bg.tu_varna.sit.kolipodnaem.entities.zaqvki;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ZaqvkiUpdateDTO {
    private int Id;
    private int avtomobil_id;
    private int klient_ID;
    private LocalDate dataZaemane;
    private LocalDate dataVrushtane;
    private int broiDni;
    private Double price;
}
