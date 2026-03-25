package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemPostDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemiView;
import bg.tu_varna.sit.kolipodnaem.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/zaemi")
public class ZaemiController {
    private final ZaemiViewRepository zaemiViewRepository;


    @GetMapping
    public List<ZaemiView> findAll() {
        return zaemiViewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZaemiView> getById(@PathVariable int id) {
        ZaemiView zaem = zaemiViewRepository.findById(id).orElse(null);

        return ResponseEntity.ok(zaem);
    }

    @Transactional
    @PostMapping
    public void PostZaem(@RequestBody ZaemanePodNaemPostDTO zaemDTO) {
        zaemiViewRepository.ZAEMANE_INS(null, zaemDTO.getKlient_id(), zaemDTO.getAvtomobil_id(), zaemDTO.getSlujitel_id(), zaemDTO.getZaemane(), zaemDTO.getBroiDni(), zaemDTO.getVrushtane());
    }

    @PatchMapping("/{id}")
    public void UpdateZaem(@PathVariable int id, @RequestBody ZaemanePodNaemPostDTO zaemDTO) {
        zaemiViewRepository.ZAEMANEPODNAEM_UPD(id, zaemDTO.getKlient_id(), zaemDTO.getAvtomobil_id(), zaemDTO.getSlujitel_id(), zaemDTO.getZaemane(), zaemDTO.getBroiDni(), zaemDTO.getVrushtane());
    }

    @DeleteMapping("/{id}")
    public void DeleteZaem(@PathVariable int id) {
        zaemiViewRepository.ZAEMANEPODNAEM_DEL(id);
    }
}
