package lt.solar.service;

import lt.solar.entity.Alert;
import lt.solar.entity.EnergyReading;
import lt.solar.repository.AlertRepository;
import lt.solar.repository.EnergyReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyReadingService {

    private final EnergyReadingRepository energyReadingRepository;
    private final AlertRepository alertRepository;

    public EnergyReadingService(EnergyReadingRepository energyReadingRepository,
                                AlertRepository alertRepository) {
        this.energyReadingRepository = energyReadingRepository;
        this.alertRepository = alertRepository;
    }

    public EnergyReading save(EnergyReading reading) {

        if (reading.getProducedPower() < 10) {
            Alert alert = new Alert();
            alert.setMessage("Per mažai energijos");
            alert.setLevel("LOW");
            alert.setSolarPark(reading.getSolarPark());
            alertRepository.save(alert);
        }

        if (reading.getProducedPower() > 100) {
            Alert alert = new Alert();
            alert.setMessage("Per daug energijos");
            alert.setLevel("HIGH");
            alert.setSolarPark(reading.getSolarPark());
            alertRepository.save(alert);
        }

        return energyReadingRepository.save(reading);
    }

    public List<EnergyReading> getAll() {
        return energyReadingRepository.findAll();
    }

    public EnergyReading getById(Long id) {
        return energyReadingRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        energyReadingRepository.deleteById(id);
    }
}