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
    @Transactional
    public List<AvtomobilView> findAll(
            @RequestParam(required = false) String marka,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String vid,
            @RequestParam(required = false) String cvqt,
            @RequestParam(required = false) Double cena,
            @RequestParam(required = false) Integer godina) {
        return avtomobilRepository.filteredAutomobiles(marka, model, vid, cvqt, cena, godina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvtomobilView> getById(@PathVariable int id) {
        AvtomobilView avtomobil = avtomobilRepository.findById(id).orElse(null);

        return ResponseEntity.ok(avtomobil);
    }
    @Transactional
    @GetMapping("/latest")
    public List<AvtomobilView> findAll() {
        return avtomobilRepository.latestSixAutomobiles();
    }

    @Transactional
    @PostMapping
    public void PostAvtomobil(@RequestBody AvtomobilPostDTO avtomobilDto) {

        avtomobilRepository.AddNewAvtomobil(avtomobilDto.getId(), avtomobilDto.getMarka(), avtomobilDto.getModel(), avtomobilDto.getVid(), avtomobilDto.getGodina(), avtomobilDto.getIzminatiKilometri(), avtomobilDto.getCvqt(), avtomobilDto.getCenaZaDen(), avtomobilDto.getEkstri());
    }

    @PatchMapping("/{id}")
    public void UpdateAvtomobil(@PathVariable int id, @RequestBody AvtomobilUpdateDTO avtomobilDto) {
        avtomobilRepository.AVTOMOBIL_UPD(avtomobilDto.getId(), avtomobilDto.getIzminatiKilometri(), avtomobilDto.getCvqt(), avtomobilDto.getSpec());
    }

    @DeleteMapping("/{id}")
    public void DeleteAvtomobil(@PathVariable int id) {
        avtomobilRepository.AVTOMOBIL_DEL(id);
    }
}
