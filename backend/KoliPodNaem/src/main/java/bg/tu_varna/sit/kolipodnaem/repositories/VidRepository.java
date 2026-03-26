package bg.tu_varna.sit.kolipodnaem.repositories;

import bg.tu_varna.sit.kolipodnaem.entities.Vid.Vid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VidRepository extends JpaRepository<Vid, Integer> {
}
