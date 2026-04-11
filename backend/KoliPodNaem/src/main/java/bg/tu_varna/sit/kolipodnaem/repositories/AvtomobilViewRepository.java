package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AvtomobilViewRepository extends JpaRepository<AvtomobilView, Integer> {
    @Procedure(procedureName = "AddNewAvtomobil")
    public void AddNewAvtomobil(
            @Param("p_marka") String marka,
            @Param("p_model") String model,
            @Param("p_vid") String vid,
            @Param("p_godina") int godina,
            @Param("p_cvqt") String cvqt,
            @Param("p_ekstri") String ekstri,
            @Param("p_cenaZaDen") double cenaZaDen,
            @Param("p_izminatiKilometri") int kilometri,
            @Param("p_img_url")  String img_url);

    @Procedure(procedureName = "updateCar")
    public void updateCar(
            @Param("p_id") int id,
            @Param("p_marka") String marka,
            @Param("p_model") String model,
            @Param("p_vid") String vid,
            @Param("p_godina") int godina,
            @Param("p_cvqt") String cvqt,
            @Param("p_ekstri") String ekstri,
            @Param("p_cenaZaDen") double cenaZaDen,
            @Param("p_izminatiKilometri") int kilometri,
            @Param("p_img_url")  String img_url);

    @Procedure(procedureName = "fetchCar")
    public AvtomobilView fetchCar(@Param("p_id") Integer id);

    @Procedure(procedureName = "filteredAutomobiles")
    public List<AvtomobilView> filteredAutomobiles(
            @Param("p_marka") String marka,
            @Param("p_model") String model,
            @Param("p_vid") String vid,
            @Param("p_cvqt") String cvqt,
            @Param("p_cena") Double cena,
            @Param("p_godina") Integer godina,
            @Param("p_dataZaemane") String dataZaemane,
            @Param("p_dataVrushtane") String dataVrushtane
    );

    @Procedure(procedureName = "latestSixAutomobiles")
    public List<AvtomobilView> latestSixAutomobiles();

    @Procedure(procedureName = "deleteCar")
    public void deleteCar(@Param("p_id") Integer id);
}
