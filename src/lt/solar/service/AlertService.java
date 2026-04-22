package lt.solar.service;

import lt.solar.entity.Alert;
import lt.solar.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository repository;

    public AlertService(AlertRepository repository) {
        this.repository = repository;
    }

    public Alert save(Alert alert) {
        return repository.save(alert);
    }

    public List<Alert> getAll() {
        return repository.findAll();
    }
}