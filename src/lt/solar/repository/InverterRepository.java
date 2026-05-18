package lt.solar.repository;

import lt.solar.entity.Inverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InverterRepository extends JpaRepository<Inverter, Long> {
}