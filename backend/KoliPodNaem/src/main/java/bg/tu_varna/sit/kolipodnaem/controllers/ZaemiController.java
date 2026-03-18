package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.Avtomobil;
import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilDTO;
import bg.tu_varna.sit.kolipodnaem.entities.Klienti.Klient;
import bg.tu_varna.sit.kolipodnaem.entities.Slujiteli.Slujitel;
import bg.tu_varna.sit.kolipodnaem.entities.Specifications.SpecificationDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaem;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemDTO;
import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaemPostDTO;
import bg.tu_varna.sit.kolipodnaem.repositories.AvtomobilRepository;
import bg.tu_varna.sit.kolipodnaem.repositories.KlientRepository;
import bg.tu_varna.sit.kolipodnaem.repositories.SlujitelRepository;
import bg.tu_varna.sit.kolipodnaem.repositories.ZaemiRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/zaemi")
public class ZaemiController {
    private ZaemiRepository zaemiRepository;
    private KlientRepository klientRepository;
    private SlujitelRepository slujitelRepository;
    private AvtomobilRepository avtomobilRepository;

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

    @GetMapping("/{id}")
    public ResponseEntity<ZaemanePodNaemDTO> getById(@PathVariable int id)
    {
        var zaem = zaemiRepository.findById(id).orElse(null);

        if(zaem == null) return ResponseEntity.notFound().build();

        ZaemanePodNaemDTO zaemDTO = new ZaemanePodNaemDTO(zaem.getZaem_ID(),
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
        );

        return ResponseEntity.ok(zaemDTO);
    }

    @PostMapping
    public void PostZaem(@RequestBody ZaemanePodNaemPostDTO zaemDTO)
    {
        Slujitel slujitel = slujitelRepository.findById(zaemDTO.getSlujitel_id()).orElse(null);
        Klient klient = klientRepository.findById(zaemDTO.getKlient_id()).orElse(null);
        Avtomobil avtomobil = avtomobilRepository.findById(zaemDTO.getAvtomobil_id()).orElse(null);

        zaemiRepository.save(
                new ZaemanePodNaem(zaemDTO.getId(),
                        zaemDTO.getDataZaemane(),
                        zaemDTO.getDataVrushtane(),
                        zaemDTO.getBroiDni(),
                        avtomobil, klient, slujitel));
    }

    @PatchMapping("/{id}")
//    public void UpdateZaem(@PathVariable int id, @RequestBody ZaemanePodNaemPostDTO zaemDTO)
//    {
//        Slujitel slujitel = slujitelRepository.findById(zaemDTO.getSlujitel_id()).orElse(null);
//        Klient klient = klientRepository.findById(zaemDTO.getKlient_id()).orElse(null);
//        Avtomobil avtomobil = avtomobilRepository.findById(zaemDTO.getAvtomobil_id()).orElse(null);
//
//        zaemiRepository.(
//                new ZaemanePodNaem(zaemDTO.getId(),
//                        zaemDTO.getDataZaemane(),
//                        zaemDTO.getDataVrushtane(),
//                        zaemDTO.getBroiDni(),
//                        avtomobil, klient, slujitel));
//    }

    @DeleteMapping("/{id}")
    public void DeleteZaem(@PathVariable int id)
    {
        zaemiRepository.deleteById(id);
    }
}
