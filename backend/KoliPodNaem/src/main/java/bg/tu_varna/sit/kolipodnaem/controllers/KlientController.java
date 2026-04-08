package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Gradove.Gradove;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.*;
import bg.tu_varna.sit.kolipodnaem.repositories.GradoveRepository;
import bg.tu_varna.sit.kolipodnaem.repositories.KlientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/klient")
public class KlientController {
    private KlientRepository klientRepository;
    private GradoveRepository gradoveRepository;

    @GetMapping
    public List<KlientDTO> getKlients(@RequestParam(required = false) String name){
        return klientRepository.findAll().stream().map(klient -> new KlientDTO(
                klient.getKlient_Id(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad().getGrad(), klient.getGrad().getDurjavi().getDurjava()), klient.getRolq()
        )).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KlientDTO> getKlientById(@PathVariable int id){
        Klient klient = klientRepository.findById(id).orElse(null);
        if(klient == null) return ResponseEntity.notFound().build();
        KlientDTO dto = new KlientDTO(
                klient.getKlient_Id(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad().getGrad(), klient.getGrad().getDurjavi().getDurjava()), klient.getRolq()
        );
        return ResponseEntity.ok(dto);
    }

    @Transactional
    @PostMapping("/login")
    public ResponseEntity<KlientDTO> login(@RequestBody LoginDTO loginDTO){
        Klient klient = klientRepository.login(loginDTO.getEmail(), loginDTO.getPassword());
        if(klient == null) return ResponseEntity.notFound().build();
        KlientDTO dto = new KlientDTO(
                klient.getKlient_Id(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad().getGrad(), klient.getGrad().getDurjavi().getDurjava()), klient.getRolq()
        );
        return ResponseEntity.ok(dto);
    }


    @Transactional(Transactional.TxType.SUPPORTS)
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO){
        try{
            Klient klient = klientRepository.register(registerDTO.getIme(), registerDTO.getEmail(), registerDTO.getPassword(), registerDTO.getTelefon(),registerDTO.getAdress().getStreet(), registerDTO.getAdress().getCity(), registerDTO.getAdress().getCountry() );
            if(klient == null) return ResponseEntity.notFound().build();
            KlientDTO dto = new KlientDTO(
                    klient.getKlient_Id(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad().getGrad(), klient.getGrad().getDurjavi().getDurjava()), klient.getRolq()
            );
            return ResponseEntity.ok(dto);
        }
        catch (SQLException e){
            return ResponseEntity.status(409).body(e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteKlientById(@PathVariable int id){
        Klient klient = klientRepository.findById(id).orElse(null);
        if(klient == null) return ResponseEntity.notFound().build();
        klientRepository.delete(klient);
        return ResponseEntity.ok().build();
    }

}
