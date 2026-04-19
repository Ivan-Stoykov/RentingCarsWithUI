package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilViewDTO;
import bg.tu_varna.sit.kolipodnaem.entities.otdadeni.OtdadeniView;
import bg.tu_varna.sit.kolipodnaem.entities.otdadeni.OtdavaneDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiUpdateDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.OtdadeniViewRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/otdavaniq")
public class OtdadeniController {
    private OtdadeniViewRepository otdadeniViewRepository;

    @Transactional
    @GetMapping
    public List<ZaqvkiDTO> getAllOtdadeni() {
        return otdadeniViewRepository.findAll().stream().map(zaem -> new ZaqvkiDTO(
                zaem.getZaem_id(),
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                zaem.getPrice(),
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
    @GetMapping("/zaOtdavane")
    public List<ZaqvkiDTO> getZaOtdavane(@RequestParam(required = false) String email) {
        return otdadeniViewRepository.fetchZaOtdavane(email).stream().map(zaem -> new ZaqvkiDTO(
                zaem.getZaem_id(),
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                zaem.getPrice(),
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
    @GetMapping("/otdadeni")
    public List<ZaqvkiDTO> getOtdadeni(@RequestParam(required = false) String email) {
        return otdadeniViewRepository.fetchOtdadeni(email).stream().map(zaem -> new ZaqvkiDTO(
                zaem.getZaem_id(),
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                zaem.getPrice(),
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
    @GetMapping("{id}")
    public ZaqvkiDTO getOtdavane(@PathVariable int id) {
        OtdadeniView zaem = otdadeniViewRepository.getReferenceById(id);
        return new ZaqvkiDTO(
                zaem.getZaem_id(),
                zaem.getKlient_ID(),
                zaem.getKlient(),
                zaem.getEmail(),
                zaem.getDatazaemane(),
                zaem.getDatavrushtane(),
                zaem.getBroidni(),
                zaem.getPrice(),
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
                ));
    }

    @Transactional
    @PostMapping("/otdavane")
    public void otdavane(@RequestBody OtdavaneDTO otdavane) {
        otdadeniViewRepository.otdavane(otdavane.getZaem_id(), otdavane.getData());

    }

    @Transactional
    @PostMapping("/vrushtane")
    public void vrushtane(@RequestBody OtdavaneDTO vrushtane) {
        otdadeniViewRepository.vrushtane(vrushtane.getZaem_id(), vrushtane.getData());

    }
    @Transactional
    @PutMapping("/{id}")
    public void UpdateZaem(@PathVariable int id, @RequestBody ZaqvkiUpdateDTO zaemDTO) {
        otdadeniViewRepository.updateZaem(zaemDTO.getId(), zaemDTO.getAvtomobil_id(), zaemDTO.getKlient_ID(),  zaemDTO.getDataZaemane(), zaemDTO.getDataVrushtane(), zaemDTO.getBroiDni());
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteZaem(@PathVariable int id) {
        otdadeniViewRepository.deleteRent(id);
    }

}
