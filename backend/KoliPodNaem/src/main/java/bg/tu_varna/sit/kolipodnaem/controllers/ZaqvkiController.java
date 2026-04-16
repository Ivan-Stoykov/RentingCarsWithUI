package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilViewDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiPostDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiUpdateDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiView;
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
public class ZaqvkiController {
    private final ZaqvkiViewRepository zaqvkiViewRepository;


    @GetMapping
    public List<ZaqvkiDTO> findAll() {
        return zaqvkiViewRepository.findAll().stream().map(zaem -> new ZaqvkiDTO(
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
    public ResponseEntity<ZaqvkiDTO> getById(@PathVariable int id) {
        ZaqvkiView zaem = zaqvkiViewRepository.fetchRent(id);

        return ResponseEntity.ok(new ZaqvkiDTO(
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
    public List<ZaqvkiDTO> getClientRents(@PathVariable int id){
        return zaqvkiViewRepository.clientRents(id).stream().map(zaem -> new ZaqvkiDTO(
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
    public void PostZaem(@RequestBody ZaqvkiPostDTO zaemDTO) {
        zaqvkiViewRepository.newZaem(zaemDTO.getAvtomobil_id(), zaemDTO.getKlient_id(),  zaemDTO.getZaemane(), zaemDTO.getVrushtane(), zaemDTO.getBroiDni());
    }

    @Transactional
    @PutMapping("/{id}")
    public void UpdateZaem(@PathVariable int id, @RequestBody ZaqvkiUpdateDTO zaemDTO) {
        zaqvkiViewRepository.updateZaem(zaemDTO.getId(), zaemDTO.getAvtomobil_id(), zaemDTO.getKlient_ID(),  zaemDTO.getDataZaemane(), zaemDTO.getDataVrushtane(), zaemDTO.getBroiDni());
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void DeleteZaem(@PathVariable int id) {
        zaqvkiViewRepository.deleteRent(id);
    }
}
