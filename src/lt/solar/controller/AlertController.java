package lt.solar.controller;

import lt.solar.entity.Alert;
import lt.solar.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins = "*")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public Alert create(@RequestBody Alert alert) {
        return alertService.save(alert);
    }

    @GetMapping
    public List<Alert> getAll() {
        return alertService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alertService.delete(id);
    }
    @GetMapping("/{id}")
    public Alert getById(@PathVariable Long id) {
        return alertService.getById(id);
    }

    @PutMapping("/{id}/close")
    public Alert close(@PathVariable Long id) {
        return alertService.close(id);
    }
}