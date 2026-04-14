package bg.tu_varna.sit.kolipodnaem.entities.Klienti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String ime;
    private String email;
    private String password;
    private String telefon;
    private AddressDTO address;
}
