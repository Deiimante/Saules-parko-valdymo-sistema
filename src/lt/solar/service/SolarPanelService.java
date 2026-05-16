package lt.solar.service;

import lt.solar.entity.SolarPanel;
import lt.solar.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarPanelService {

    private final SolarPanelRepository repository;

    public SolarPanelService(SolarPanelRepository repository) {
        this.repository = repository;
    }

    public SolarPanel save(SolarPanel panel) {
        return repository.save(panel);
    }

    public List<SolarPanel> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}