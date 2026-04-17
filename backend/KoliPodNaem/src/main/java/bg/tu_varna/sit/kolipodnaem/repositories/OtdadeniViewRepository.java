package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.otdadeni.OtdadeniView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OtdadeniViewRepository extends JpaRepository<OtdadeniView, Integer>{

    @Procedure(name = "fetchZaOtdavane")
    public List<OtdadeniView> fetchZaOtdavane();

    @Procedure(name = "fetchOtdadeni")
    public List<OtdadeniView> fetchOtdadeni();

    @Procedure(name = "otdavane")
    public void otdavane(@Param("p_id") Integer id, @Param("p_dataotdavane") LocalDateTime dataOtdavane);

    @Procedure(name = "vrushtane")
    public void vrushtane(@Param("p_id") Integer id, @Param("p_datavrushtane") LocalDateTime dataVrushtane);

    @Procedure(procedureName = "updateZaem")
    public void updateZaem(
            @Param("p_id") int p_id,
            @Param("p_avtomobil_id") int avtomobilId,
            @Param("p_klient_id") int klientId,
            @Param("p_zaemane") LocalDate zaemane,
            @Param("p_vrushtane") LocalDate vrushtane,
            @Param("p_broiDni") int broiDni
    );

    @Procedure(procedureName = "deleteOtdavane")
    public void deleteRent(@Param("p_id") Integer id);
}