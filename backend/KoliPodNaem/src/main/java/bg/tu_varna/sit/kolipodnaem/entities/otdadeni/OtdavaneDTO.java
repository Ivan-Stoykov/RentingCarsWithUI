package bg.tu_varna.sit.kolipodnaem.entities.otdadeni;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class OtdavaneDTO {
    private Integer zaem_id;
    private LocalDateTime data;

}
