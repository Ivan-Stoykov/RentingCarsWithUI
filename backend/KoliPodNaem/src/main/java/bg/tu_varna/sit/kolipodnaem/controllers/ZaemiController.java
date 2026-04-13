package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilViewDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemPostDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemUpdateDTO;
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
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                new AvtomobilViewDTO(
                        zaem.getAvtomobil_id(),
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

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<ZaemanePodNaemDTO> getById(@PathVariable int id) {
        ZaemiView zaem = zaemiViewRepository.fetchRent(id);

        return ResponseEntity.ok(new ZaemanePodNaemDTO(
                zaem.getZaem_id(),
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                new AvtomobilViewDTO(
                        zaem.getAvtomobil_id(),
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
        ));
    }

    @Transactional
    @GetMapping("/{id}/rents")
    public List<ZaemanePodNaemDTO> getClientRents(@PathVariable int id){
        return zaemiViewRepository.clientRents(id).stream().map(zaem -> new ZaemanePodNaemDTO(
                zaem.getZaem_id(),
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                new AvtomobilViewDTO(
                        zaem.getAvtomobil_id(),
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

    @Transactional
    @PostMapping
    public void PostZaem(@RequestBody ZaemanePodNaemPostDTO zaemDTO) {
        zaemiViewRepository.newZaem(zaemDTO.getAvtomobil_id(), zaemDTO.getKlient_id(),  zaemDTO.getZaemane(), zaemDTO.getVrushtane(), zaemDTO.getBroiDni());
    }

    @Transactional
    @PutMapping("/{id}")
    public void UpdateZaem(@PathVariable int id, @RequestBody ZaemanePodNaemUpdateDTO zaemDTO) {
        zaemiViewRepository.updateZaem(zaemDTO.getId(), zaemDTO.getAvtomobil_id(), zaemDTO.getKlient_ID(),  zaemDTO.getDataZaemane(), zaemDTO.getDataVrushtane(), zaemDTO.getBroiDni());
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void DeleteZaem(@PathVariable int id) {
        zaemiViewRepository.deleteRent(id);
    }
}
