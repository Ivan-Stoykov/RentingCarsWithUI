package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemiView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ZaemiViewRepository extends JpaRepository<ZaemiView, Integer> {
    @Procedure(procedureName = "ZAEMANE_INS")
    public void ZAEMANE_INS(@Param("V_ID") Integer id,
                           @Param("V_Klient") int klientId,
                           @Param("V_Avtomobil") int avtomobilId,
                           @Param("V_Slujitel") int slujitelId,
                           @Param("V_dataZaemane") LocalDateTime zaemane,
                           @Param("V_BroiDni") int broiDni,
                           @Param("V_dataVrushtane") LocalDateTime vrushtane);

    @Procedure(procedureName = "ZAEMANEPODNAEM_UPD")
    public void ZAEMANEPODNAEM_UPD(@Param("V_ID") Integer id,
                            @Param("V_Klient") int klientId,
                            @Param("V_Avtomobil") int avtomobilId,
                            @Param("V_Slujitel") int slujitelId,
                            @Param("V_dataZaemane") LocalDateTime zaemane,
                            @Param("V_BroiDni") int broiDni,
                            @Param("V_dataVrushtane") LocalDateTime vrushtane);
    @Procedure(procedureName = "ZAEMANEPODNAEM_DEL")
    public void ZAEMANEPODNAEM_DEL(@Param("V_ID") Integer id);
}
