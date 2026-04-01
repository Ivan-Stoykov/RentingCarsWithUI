package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.Klienti.Klient;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.KlientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;

public interface KlientRepository extends JpaRepository<Klient, Integer> {
    @Procedure(procedureName = "login")
    public Klient login(
            @Param("p_email") String email,
            @Param("p_password") String password);
    @Procedure(procedureName = "register")
    public Klient register(
            @Param("p_ime") String ime,
            @Param("p_email") String email,
            @Param("p_password") String password,
            @Param("p_telefon") String telefon,
            @Param("p_ulica") String ulica,
            @Param("p_grad") String grad,
            @Param("p_durjava") String durjava
    ) throws  SQLException;
}
