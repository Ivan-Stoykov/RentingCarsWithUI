package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilViewDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemDTO;
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
    public List<ZaemanePodNaemDTO> findAll() {
        return zaemiViewRepository.findAll().stream().map(zaem -> new ZaemanePodNaemDTO(
                zaem.getZaem_id(),
                zaem.getKlient(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                new AvtomobilViewDTO(
                        zaem.getMarka_name(),
                        zaem.getKolamodel(),
                        zaem.getVid(),
                        zaem.getGodina(),
                        zaem.getCvqt(),
                        zaem.getIme_extra(),
                        zaem.getCena_za_den(),
                        zaem.getIzminatikilometri(),
                        zaem.getImg_url()
                )
        )).toList();

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
