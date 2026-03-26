package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilPostDTO;
import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilUpdateDTO;
import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilView;
import bg.tu_varna.sit.kolipodnaem.repositories.AvtomobilViewRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/avtomobil")
public class AvtomobilController {
    private final AvtomobilViewRepository avtomobilRepository;


    @GetMapping
    public List<AvtomobilView> findAll() {
        return avtomobilRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvtomobilView> getById(@PathVariable int id) {
        AvtomobilView avtomobil = avtomobilRepository.findById(id).orElse(null);

        return ResponseEntity.ok(avtomobil);
    }

    @Transactional
    @PostMapping
    public void PostZaem(@RequestBody AvtomobilPostDTO avtomobilDto) {

        avtomobilRepository.AddNewAvtomobil(avtomobilDto.getId(), avtomobilDto.getMarka(), avtomobilDto.getModel(), avtomobilDto.getVid(), avtomobilDto.getGodina(), avtomobilDto.getIzminatiKilometri(), avtomobilDto.getCvqt(), avtomobilDto.getCenaZaDen(), avtomobilDto.getEkstri());
    }

    @PatchMapping("/{id}")
    public void UpdateZaem(@PathVariable int id, @RequestBody AvtomobilUpdateDTO avtomobilDto) {
        avtomobilRepository.AVTOMOBIL_UPD(avtomobilDto.getId(), avtomobilDto.getIzminatiKilometri(), avtomobilDto.getCvqt(), avtomobilDto.getSpec());
    }

    @DeleteMapping("/{id}")
    public void DeleteZaem(@PathVariable int id) {
        avtomobilRepository.AVTOMOBIL_DEL(id);
    }
}
