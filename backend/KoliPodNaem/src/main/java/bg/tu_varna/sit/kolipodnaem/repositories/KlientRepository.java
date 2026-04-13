package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.Klienti.KlientView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;

public interface KlientRepository extends JpaRepository<KlientView, Integer> {
    @Procedure(procedureName = "login")
    public KlientView login(
            @Param("p_email") String email,
            @Param("p_password") String password);
    @Procedure(procedureName = "register")
    public KlientView register(
            @Param("p_ime") String ime,
            @Param("p_email") String email,
            @Param("p_password") String password,
            @Param("p_telefon") String telefon,
            @Param("p_ulica") String ulica,
            @Param("p_grad") String grad,
            @Param("p_durjava") String durjava
    ) throws  SQLException;

    @Procedure(procedureName = "deleteClient")
    public void deleteClient(@Param("p_id") Integer id);

    @Procedure(procedureName = "updateClient")
    public void updateClient(
            @Param("p_id") Integer id,
            @Param("p_ime") String ime,
            @Param("p_email") String email,
            @Param("p_telefon") String telefon,
            @Param("p_ulica") String ulica,
            @Param("p_grad") String grad,
            @Param("p_durjava") String durjava,
            @Param("p_rolq") String rolq
    );

    @Procedure(procedureName = "fetchClient")
    public KlientView fetchClient(@Param("p_id") Integer id);

    @Procedure(procedureName = "getClients")
    public List<KlientView> getClients(@Param("p_ime") String ime);
}
