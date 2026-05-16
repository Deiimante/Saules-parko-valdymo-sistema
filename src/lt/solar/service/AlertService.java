package lt.solar.service;

import lt.solar.entity.Alert;
import lt.solar.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert save(Alert alert) {
        return alertRepository.save(alert);
    }

    public List<Alert> getAll() {
        return alertRepository.findAll();
    }

    public void delete(Long id) {
        alertRepository.deleteById(id);
    }
    public Alert getById(Long id) {
        return alertRepository.findById(id).orElseThrow();    }

    public Alert close(Long id) {
        Alert alert = alertRepository.findById(id).orElseThrow();
        alert.setLevel("CLOSED");
        return alertRepository.save(alert);
    }
}