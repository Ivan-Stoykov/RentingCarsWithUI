package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Gradove.Gradove;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.Klient;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.KlientDTO;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.KlientPostDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.GradoveRepository;
import bg.tu_varna.sit.kolipodnaem.repositories.KlientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/klient")
public class KlientController {
    private KlientRepository klientRepository;
    private GradoveRepository gradoveRepository;

    @GetMapping
    public List<KlientDTO> getKlients(){
        return klientRepository.findAll().stream().map(klient -> new KlientDTO(
                klient.getKlient_Id(), klient.getIme(), klient.getTelefon(), klient.getUlica(), klient.getGrad().getGrad(), klient.getGrad().getDurjavi().getDurjava()
        )).toList();
    }

    @PostMapping
    public ResponseEntity createKlient(@RequestBody KlientPostDTO klient){
        Gradove gradove = gradoveRepository.findById(klient.getGradId()).orElse(null);
        Klient kl = new Klient();
        kl.setIme(klient.getIme());
        kl.setTelefon(klient.getTelefon());
        kl.setUlica(klient.getUlica());
        kl.setGrad(gradove);
        klientRepository.save(kl);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KlientDTO> getKlientById(@PathVariable int id){
        Klient klient = klientRepository.findById(id).orElse(null);
        if(klient == null) return ResponseEntity.notFound().build();
        KlientDTO dto = new KlientDTO(
                klient.getKlient_Id(), klient.getIme(), klient.getTelefon(), klient.getUlica(), klient.getGrad().getGrad(), klient.getGrad().getDurjavi().getDurjava()
        );
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteKlientById(@PathVariable int id){
        Klient klient = klientRepository.findById(id).orElse(null);
        if(klient == null) return ResponseEntity.notFound().build();
        klientRepository.delete(klient);
        return ResponseEntity.ok().build();
    }

}
