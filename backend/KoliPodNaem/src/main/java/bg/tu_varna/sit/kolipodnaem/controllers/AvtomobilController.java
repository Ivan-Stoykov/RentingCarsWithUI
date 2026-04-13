package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilPostDTO;
import bg.tu_varna.sit.kolipodnaem.entities.Avtomobil.AvtomobilView;
import bg.tu_varna.sit.kolipodnaem.repositories.AvtomobilViewRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            @RequestParam(required = false) String avtomobil,
            @RequestParam(required = false) String vid,
            @RequestParam(required = false) String cvqt,
            @RequestParam(required = false) Double cena,
            @RequestParam(required = false) Integer godina,
            @RequestParam(required = false) String dataZaemane,
            @RequestParam(required = false) String dataVrushtane) {
        return avtomobilRepository.filteredAutomobiles(avtomobil, vid, cvqt, cena, godina, dataZaemane, dataVrushtane);
    }
    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<AvtomobilView> getById(@PathVariable int id) {
        AvtomobilView avtomobil = avtomobilRepository.fetchCar(id);

        return ResponseEntity.ok(avtomobil);
    }

    @Transactional
    @GetMapping("/{id}/availability")
    public boolean availability(@PathVariable int id, @RequestParam LocalDate start, @RequestParam LocalDate end) {
        return avtomobilRepository.checkAvailability(id, start, end);
    }

    @Transactional
    @GetMapping("/latest")
    public List<AvtomobilView> findLatest() {
        return avtomobilRepository.latestSixAutomobiles();
    }

    @Transactional
    @PostMapping
    public void PostAvtomobil(@RequestBody AvtomobilPostDTO avtomobilDto) {

        avtomobilRepository.AddNewAvtomobil(
                avtomobilDto.getMarka(),
                avtomobilDto.getModel(),
                avtomobilDto.getVid(),
                avtomobilDto.getGodina(),
                avtomobilDto.getCvqt(),
                avtomobilDto.getEkstri(),
                avtomobilDto.getCenaZaDen(),
                avtomobilDto.getIzminatiKilometri(),
                avtomobilDto.getImg_url());
    }

    @Transactional
    @PutMapping("/{id}")
    public void UpdateAvtomobil(@PathVariable int id, @RequestBody AvtomobilPostDTO avtomobilDto) {
        avtomobilRepository.updateCar(
                id,
                avtomobilDto.getMarka(),
                avtomobilDto.getModel(),
                avtomobilDto.getVid(),
                avtomobilDto.getGodina(),
                avtomobilDto.getCvqt(),
                avtomobilDto.getEkstri(),
                avtomobilDto.getCenaZaDen(),
                avtomobilDto.getIzminatiKilometri(),
                avtomobilDto.getImg_url());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteAvtomobil(@PathVariable int id) {
        avtomobilRepository.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
