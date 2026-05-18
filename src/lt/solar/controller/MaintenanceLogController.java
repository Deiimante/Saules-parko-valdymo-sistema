package lt.solar.controller;

import lt.solar.entity.MaintenanceLog;
import lt.solar.service.MaintenanceLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parks/{parkId}/maintenance")
@CrossOrigin(origins = "*")
public class MaintenanceLogController {

    private final MaintenanceLogService service;

    public MaintenanceLogController(MaintenanceLogService service) {
        this.service = service;
    }

    @PostMapping
    public MaintenanceLog create(@PathVariable Long parkId, @RequestBody MaintenanceLog log) {
        return service.save(log);
    }

    @GetMapping
    public List<MaintenanceLog> getAll(@PathVariable Long parkId) {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MaintenanceLog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MaintenanceLog update(@PathVariable Long id, @RequestBody MaintenanceLog log) {
        return service.update(id, log);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}