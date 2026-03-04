package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.KolaModel.KolaModel;

import bg.tu_varna.sit.kolipodnaem.entities.KolaModel.KolaModelDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.KolaModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/model")
public class KolaModelController {
    private KolaModelRepository modelRepository;

    @GetMapping
    public Iterable<KolaModelDTO> findAll() {
        return modelRepository.findAll().stream().map(kolaModel -> new KolaModelDTO(kolaModel.getId(), kolaModel.getKolamodel(), kolaModel.getMarka().getMarka())).toList();
    }
}
