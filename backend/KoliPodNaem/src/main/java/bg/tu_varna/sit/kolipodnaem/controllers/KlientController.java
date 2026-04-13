package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Gradove.Gradove;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.*;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemiView;
import bg.tu_varna.sit.kolipodnaem.repositories.GradoveRepository;
import bg.tu_varna.sit.kolipodnaem.repositories.KlientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Transactional
    @GetMapping
    public List<KlientDTO> getKlients(@RequestParam(required = false) String name){
        return klientRepository.getClients(name).stream().map(
                klient -> new KlientDTO(
                        klient.getKlient_ID(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad(), klient.getDurjava()), klient.getRolq()
                )
        ).toList();
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<KlientDTO> getKlientById(@PathVariable int id){
        KlientView klient = klientRepository.fetchClient(id);
        if(klient == null) return ResponseEntity.notFound().build();
        KlientDTO dto = new KlientDTO(
                klient.getKlient_ID(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad(), klient.getDurjava()), klient.getRolq()
        );
        return ResponseEntity.ok(dto);
    }

    @Transactional
    @PostMapping("/login")
    public ResponseEntity<KlientDTO> login(@RequestBody LoginDTO loginDTO){
        KlientView klient = klientRepository.login(loginDTO.getEmail(), loginDTO.getPassword());
        if(klient == null) return ResponseEntity.notFound().build();
        KlientDTO dto = new KlientDTO(
                klient.getKlient_ID(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad(), klient.getDurjava()), klient.getRolq()
        );
        return ResponseEntity.ok(dto);
    }


    @Transactional(Transactional.TxType.SUPPORTS)
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO){
        try{
            KlientView klient = klientRepository.register(registerDTO.getIme(), registerDTO.getEmail(), registerDTO.getPassword(), registerDTO.getTelefon(),registerDTO.getAdress().getStreet(), registerDTO.getAdress().getCity(), registerDTO.getAdress().getCountry() );
            if(klient == null) return ResponseEntity.notFound().build();
            KlientDTO dto = new KlientDTO(
                    klient.getKlient_ID(), klient.getIme(), klient.getTelefon(), klient.getEmail(), new AddressDTO(klient.getUlica(), klient.getGrad(), klient.getDurjava()), klient.getRolq()
            );
            return ResponseEntity.ok(dto);
        }
        catch (SQLException e){
            return ResponseEntity.status(409).body(e.getLocalizedMessage());
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity updateKlientById(@PathVariable int id, @RequestBody KlientDTO klientDTO){
        klientRepository.updateClient(id, klientDTO.getIme(), klientDTO.getEmail(), klientDTO.getTelefon(), klientDTO.getAddress().getStreet(), klientDTO.getAddress().getCity(), klientDTO.getAddress().getCountry(), klientDTO.getRolq());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteKlientById(@PathVariable int id){
        klientRepository.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
