package lt.solar.repository;

import lt.solar.entity.SolarPark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarParkRepository extends JpaRepository<SolarPark, Long> {
}