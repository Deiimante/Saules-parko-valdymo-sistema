package lt.solar.service;

import lt.solar.entity.SolarPark;
import lt.solar.repository.SolarParkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarParkService {

    private final SolarParkRepository repository;

    public SolarParkService(SolarParkRepository repository) {
        this.repository = repository;
    }

    public SolarPark create(SolarPark park) {
        return repository.save(park);
    }

    public List<SolarPark> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}