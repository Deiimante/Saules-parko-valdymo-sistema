package lt.solar.repository;

import lt.solar.entity.EnergyReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyReadingRepository extends JpaRepository<EnergyReading, Long> {
}