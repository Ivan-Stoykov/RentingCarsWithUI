package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemiView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ZaemiViewRepository extends JpaRepository<ZaemiView, Integer> {
    @Procedure(procedureName = "newZaem")
    public void newZaem(
            @Param("p_avtomobil_id") int avtomobilId,
            @Param("p_klient_id") int klientId,
            @Param("p_zaemane") LocalDate zaemane,
            @Param("p_vrushtane") LocalDate vrushtane,
            @Param("p_broiDni") int broiDni
    );

    @Procedure(procedureName = "updateZaem")
    public void updateZaem(
            @Param("p_id") int p_id,
            @Param("p_avtomobil_id") int avtomobilId,
            @Param("p_klient_id") int klientId,
            @Param("p_zaemane") LocalDate zaemane,
            @Param("p_vrushtane") LocalDate vrushtane,
            @Param("p_broiDni") int broiDni
    );

    @Procedure(procedureName = "fetchRent")
    public ZaemiView fetchRent(@Param("p_id") Integer id);


    @Procedure(procedureName = "clientRents")
    public List<ZaemiView> clientRents(@Param("p_id") Integer id);

    @Procedure(procedureName = "deleteRent")
    public void deleteRent(@Param("p_id") Integer id);
}
