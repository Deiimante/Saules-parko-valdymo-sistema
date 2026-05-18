package lt.solar.service;

import lt.solar.entity.MaintenanceLog;
import lt.solar.repository.MaintenanceLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceLogService {

    private final MaintenanceLogRepository repository;

    public MaintenanceLogService(MaintenanceLogRepository repository) {
        this.repository = repository;
    }

    public MaintenanceLog save(MaintenanceLog group) {
        return repository.save(group);
    }

    public List<MaintenanceLog> getAll() {
        return repository.findAll();
    }

    public MaintenanceLog getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public MaintenanceLog update(Long id, MaintenanceLog group) {
        MaintenanceLog existing = repository.findById(id).orElseThrow();

        existing.setGroupName(group.getGroupName());
        existing.setResponsiblePerson(group.getResponsiblePerson());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}