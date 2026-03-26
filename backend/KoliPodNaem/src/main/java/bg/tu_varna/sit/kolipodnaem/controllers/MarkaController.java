package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Marka.KolaModelDTOForMarka;
import bg.tu_varna.sit.kolipodnaem.entities.Marka.Marka;
import bg.tu_varna.sit.kolipodnaem.entities.Marka.MarkaDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.MarkaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/marka")
public class MarkaController {
    private MarkaRepository markaRepository;
    @GetMapping
    public Iterable<MarkaDTO> findAll() {
        return markaRepository.findAll().stream()
                .map(marka -> new MarkaDTO(
                        marka.getId(),
                        marka.getMarka(),
                        marka.getKolamodels().stream()
                                .map(kolaModel -> new KolaModelDTOForMarka(
                                        kolaModel.getId(),
                                        kolaModel.getKolamodel()))
                                .toList()))
                .toList();
    }

    @GetMapping("/list")
    public Iterable<String> markaList()
    {
        return markaRepository.findAll().stream().map(Marka::getMarka).toList();
    }

}
