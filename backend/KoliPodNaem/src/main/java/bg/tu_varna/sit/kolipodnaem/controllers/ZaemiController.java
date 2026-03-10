package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilDTO;
import bg.tu_varna.sit.kolipodnaem.entities.Specifications.SpecificationDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.ZaemiRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/zaemi")
public class ZaemiController {
    private ZaemiRepository zaemiRepository;

    @GetMapping
    public List<ZaemanePodNaemDTO> findAll()
    {
        return zaemiRepository.findAll().stream()
                .map(zaem -> new ZaemanePodNaemDTO(
                        zaem.getZaem_ID(),
                        zaem.getKlient().getIme(),
                        zaem.getSlujitel().getIme(),
                        zaem.getDatazaemane(),
                        zaem.getDatavrushtane(),
                        zaem.getBroidni(),
                        new AvtomobilDTO(
                                zaem.getAvtomobil().getAvtomobilID(),
                                zaem.getAvtomobil().getCvqt().getCvqt(),
                                zaem.getAvtomobil().getIzminatiKilometri(),
                                new SpecificationDTO(
                                       zaem.getAvtomobil().getSpecification().getSpec_ID(),
                                        zaem.getAvtomobil().getSpecification().getKolamodel().getMarka().getMarka(),
                                        zaem.getAvtomobil().getSpecification().getKolamodel().getKolamodel(),
                                        zaem.getAvtomobil().getSpecification().getVid().getVid(),
                                        zaem.getAvtomobil().getSpecification().getEkstri().getImeExtra(),
                                        zaem.getAvtomobil().getSpecification().getGodina(),
                                        zaem.getAvtomobil().getSpecification().getCenaZaDen()
                                )
                        )
                )).toList();
    }
}
