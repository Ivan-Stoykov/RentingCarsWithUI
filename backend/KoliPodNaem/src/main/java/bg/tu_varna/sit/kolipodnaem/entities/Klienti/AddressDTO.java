package bg.tu_varna.sit.kolipodnaem.entities.Klienti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddressDTO {
    private String street;
    private String city;
    private String country;
}
