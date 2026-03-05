package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.zaemi.ZaemanePodNaem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZaemiRepository extends JpaRepository<ZaemanePodNaem, Integer> {
}
