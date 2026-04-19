package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ZaqvkiViewRepository extends JpaRepository<ZaqvkiView, Integer> {
    @Procedure(procedureName = "newZaem")
    public void newZaem(
            @Param("p_avtomobil_id") int avtomobilId,
            @Param("p_klient_id") int klientId,
            @Param("p_zaemane") LocalDate zaemane,
            @Param("p_vrushtane") LocalDate vrushtane,
            @Param("p_broiDni") int broiDni,
            @Param("p_price") Double price
    );



    @Procedure(procedureName = "fetchRent")
    public ZaqvkiView fetchRent(@Param("p_id") Integer id);

    @Procedure(procedureName = "fetchZaemi")
    public List<ZaqvkiView> allRents(@Param("p_email") String email);


    @Procedure(procedureName = "clientRents")
    public List<ZaqvkiView> clientRents(@Param("p_id") Integer id);

    @Procedure(procedureName = "clientPendingRents")
    public List<ZaqvkiView> clientPendingRents(@Param("p_id") Integer id);

    @Procedure(procedureName = "deleteZaqvka")
    public void deleteRent(@Param("p_id") Integer id);
}
