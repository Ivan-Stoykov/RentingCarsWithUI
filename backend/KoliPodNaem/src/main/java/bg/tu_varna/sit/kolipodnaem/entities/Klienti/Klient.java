package bg.tu_varna.sit.kolipodnaem.entities.Klienti;

import bg.tu_varna.sit.kolipodnaem.entities.Gradove.Gradove;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "klient")
public class Klient {
    @Id
    @Column(name = "KLIENT_ID")
    private int klient_Id;

    @Column(name = "IME")
    private String ime;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "ULICA")
    private String ulica;

    @Column(name = "rolq")
    private String rolq;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "grad_id")
    private Gradove grad;

    @OneToMany(mappedBy = "klient")
    private List<ZaemanePodNaem> zaemane;
}
