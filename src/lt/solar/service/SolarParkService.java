package lt.solar.service;

import lt.solar.entity.SolarPark;
import lt.solar.repository.SolarParkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarParkService {

    private final SolarParkRepository solarParkRepository;

    public SolarParkService(SolarParkRepository solarParkRepository) {
        this.solarParkRepository = solarParkRepository;
    }

    public SolarPark save(SolarPark solarPark) {
        return solarParkRepository.save(solarPark);
    }

    public List<SolarPark> getAll() {
        return solarParkRepository.findAll();
    }

    public SolarPark getById(Long id) {
        return solarParkRepository.findById(id).orElseThrow();
    }

    public SolarPark update(Long id, SolarPark updatedPark) {
        SolarPark park = solarParkRepository.findById(id).orElseThrow();

        park.setName(updatedPark.getName());
        park.setLocation(updatedPark.getLocation());
        park.setCapacity(updatedPark.getCapacity());

        return solarParkRepository.save(park);
    }

    public void delete(Long id) {
        solarParkRepository.deleteById(id);
    }
}