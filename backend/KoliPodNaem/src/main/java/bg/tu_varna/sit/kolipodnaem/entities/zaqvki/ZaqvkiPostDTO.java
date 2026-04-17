package bg.tu_varna.sit.kolipodnaem.entities.zaqvki;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ZaqvkiPostDTO {
    private int klient_id;
    private int avtomobil_id;
    private LocalDate zaemane;
    private LocalDate vrushtane;
    private int broiDni;
    private Double price;
}
