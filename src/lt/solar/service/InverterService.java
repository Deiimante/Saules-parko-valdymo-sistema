package lt.solar.service;

import lt.solar.entity.Inverter;
import lt.solar.repository.InverterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InverterService {

    private final InverterRepository repository;

    public InverterService(InverterRepository repository) {
        this.repository = repository;
    }

    public Inverter save(Inverter inverter) {
        return repository.save(inverter);
    }

    public List<Inverter> getAll() {
        return repository.findAll();
    }

    public Inverter getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Inverter update(Long id, Inverter inverter) {
        Inverter existing = repository.findById(id).orElseThrow();

        existing.setSerialNumber(inverter.getSerialNumber());
        existing.setModel(inverter.getModel());
        existing.setManufacturer(inverter.getManufacturer());
        existing.setMaxPowerKW(inverter.getMaxPowerKW());
        existing.setStatus(inverter.getStatus());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}