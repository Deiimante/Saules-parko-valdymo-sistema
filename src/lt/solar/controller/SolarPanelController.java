package lt.solar.controller;

import lt.solar.entity.SolarPanel;
import lt.solar.service.SolarPanelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parks/{parkId}/panels")
@CrossOrigin(origins = "*")
public class SolarPanelController {

    private final SolarPanelService service;

    public SolarPanelController(SolarPanelService service) {
        this.service = service;
    }

    @PostMapping
    public SolarPanel create(@PathVariable Long parkId, @RequestBody SolarPanel panel) {
        return service.save(panel);
    }

    @GetMapping
    public List<SolarPanel> getAll(@PathVariable Long parkId) {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SolarPanel getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public SolarPanel update(@PathVariable Long id, @RequestBody SolarPanel panel) {
        return service.update(id, panel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}