package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Cvqt.Cvqt;
import bg.tu_varna.sit.kolipodnaem.repositories.CvqtRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/cvqt")
public class CvqtController {
    private CvqtRepository cvqtRepository;
    @GetMapping
    public Iterable<Cvqt> index()
    {
        return cvqtRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvqt> findByCvqtId(@PathVariable int id)
    {
        if (cvqtRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cvqtRepository.findById(id).get());
    }

    @GetMapping("/list")
    public Iterable<String> cvqtList()
    {
        return cvqtRepository.findAll().stream().map(Cvqt::getCvqt).toList();
    }
}
