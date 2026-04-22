package lt.solar.controller;

import lt.solar.entity.Alert;
import lt.solar.repository.AlertRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertRepository alertRepository;

    public AlertController(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @GetMapping
    public List<Alert> getAll() {
        return alertRepository.findAll();
    }

    @PostMapping
    public Alert create(@RequestBody Alert alert) {
        return alertRepository.save(alert);
    }
}