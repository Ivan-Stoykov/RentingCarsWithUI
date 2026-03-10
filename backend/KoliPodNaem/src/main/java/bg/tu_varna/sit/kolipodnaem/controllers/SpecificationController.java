package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Specifications.Specification;
import bg.tu_varna.sit.kolipodnaem.entities.Specifications.SpecificationDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.SpecificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/specs")
public class SpecificationController {
    private SpecificationRepository specificationRepository;

    @GetMapping
    public List<SpecificationDTO> findAll() {
        return specificationRepository.findAll().stream()
                .map(spec -> new SpecificationDTO(
                        spec.getSpec_ID(),
                        spec.getKolamodel().getMarka().getMarka(),
                        spec.getKolamodel().getKolamodel(),
                        spec.getVid().getVid(),
                        spec.getEkstri().getImeExtra(),
                        spec.getGodina(),
                        spec.getCenaZaDen()))
                .toList();
    }
}
