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
    public SolarPanel getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public SolarPanel update(Long id, SolarPanel panel) {
        SolarPanel existing = repository.findById(id).orElseThrow();
        existing.setModel(panel.getModel());
        existing.setPower(panel.getPower());
        existing.setStatus(panel.getStatus());
        return repository.save(existing);
    }
}