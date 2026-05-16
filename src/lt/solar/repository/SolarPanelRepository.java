package lt.solar.repository;

import lt.solar.entity.SolarPanel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarPanelRepository extends JpaRepository<SolarPanel, Long> {
}