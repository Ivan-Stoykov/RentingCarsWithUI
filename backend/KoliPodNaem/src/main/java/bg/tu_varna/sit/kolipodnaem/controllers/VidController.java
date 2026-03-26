package bg.tu_varna.sit.kolipodnaem.controllers;

import bg.tu_varna.sit.kolipodnaem.entities.Cvqt.Cvqt;
import bg.tu_varna.sit.kolipodnaem.entities.Vid.Vid;
import bg.tu_varna.sit.kolipodnaem.repositories.VidRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/vid")
public class VidController {

    private final VidRepository vidRepository;

    @GetMapping("/list")
    public Iterable<String> cvqtList()
    {
        return vidRepository.findAll().stream().map(Vid::getVid).toList();
    }
}
