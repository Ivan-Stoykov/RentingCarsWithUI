package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilViewDTO;
import bg.tu_varna.sit.kolipodnaem.entities.otdadeni.OtdadeniView;
import bg.tu_varna.sit.kolipodnaem.entities.otdadeni.OtdavaneDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaqvki.ZaqvkiDTO;
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
    public List<OtdadeniView> getZaOtdavane() {
        return otdadeniViewRepository.fetchZaOtdavane();
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
}
