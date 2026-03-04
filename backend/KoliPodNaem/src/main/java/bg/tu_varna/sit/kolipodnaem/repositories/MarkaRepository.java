package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.Marka.Marka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkaRepository extends JpaRepository<Marka, Integer> {
}
