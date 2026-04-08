package bg.tu_varna.sit.kolipodnaem.entities.Klienti;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "klientview")
@Getter
@Setter
@NoArgsConstructor
@Immutable
public class KlientView {
    @Id
    @Column(name = "KLIENT_ID")
    private int klient_ID;

    @Column(name = "ime")
    private String ime;
    @Column(name = "ULICA")
    private String ulica;
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "email")
    private String email;
    @Column(name = "grad")
    private String grad;
    @Column(name = "durjava")
    private String durjava;
    @Column(name = "rolq")
    private String rolq;


}
