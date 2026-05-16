package lt.solar.controller;

import lt.solar.entity.SolarPanel;
import lt.solar.service.SolarPanelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panels")
public class SolarPanelController {

    private final SolarPanelService service;

    public SolarPanelController(SolarPanelService service) {
        this.service = service;
    }

    @PostMapping
    public SolarPanel create(@RequestBody SolarPanel panel) {
        return service.save(panel);
    }

    @GetMapping
    public List<SolarPanel> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}