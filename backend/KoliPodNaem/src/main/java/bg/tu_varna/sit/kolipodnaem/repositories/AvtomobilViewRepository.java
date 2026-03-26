package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AvtomobilViewRepository extends JpaRepository<AvtomobilView, Integer> {
    @Procedure(procedureName = "AddNewAvtomobil")
    public void AddNewAvtomobil(@Param("p_avtomobil_id") Integer id,
                                @Param("p_marka_id") int marka,
                                @Param("p_model_id") int model,
                                @Param("p_vid_id") int vid,
                                @Param("p_godina") int godina,
                                @Param("p_izminatiKilometri") int kilometri,
                                @Param("p_cvqt_id") int cvqt,
                                @Param("p_cenaZaDen") double cenaZaDen,
                                @Param("p_ekstri") String ekstri);
    @Procedure(procedureName = "AVTOMOBIL_UPD")
    public void AVTOMOBIL_UPD(@Param("V_ID") Integer id,
                                   @Param("V_Kilometri") int kilometri,
                                   @Param("V_cvqt") int cvqt,
                                   @Param("V_spec") int spec);
    @Procedure(procedureName = "AVTOMOBIL_DEL")
    public void AVTOMOBIL_DEL(@Param("V_ID") Integer id);
}
