package lt.solar.controller;

import lt.solar.entity.EnergyReading;
import lt.solar.service.EnergyReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panels/{panelId}/readings")
@CrossOrigin(origins = "*")
public class EnergyReadingController {

    private final EnergyReadingService energyReadingService;

    public EnergyReadingController(EnergyReadingService energyReadingService) {
        this.energyReadingService = energyReadingService;
    }

    @PostMapping
    public EnergyReading create(@PathVariable Long panelId, @RequestBody EnergyReading reading) {
        return energyReadingService.save(reading);
    }

    @GetMapping
    public List<EnergyReading> getAll(@PathVariable Long panelId) {
        return energyReadingService.getAll();
    }

    @GetMapping("/{id}")
    public EnergyReading getById(@PathVariable Long id) {
        return energyReadingService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        energyReadingService.delete(id);
    }

    @GetMapping("/parks/{parkId}/energy/daily")
    public List<EnergyReading> getDailyEnergy(@PathVariable Long parkId) {
        return energyReadingService.getAll();
    }

    @GetMapping("/parks/{parkId}/energy/monthly")
    public List<EnergyReading> getMonthlyEnergy(@PathVariable Long parkId) {
        return energyReadingService.getAll();
    }

    @GetMapping("/parks/{parkId}/energy/summary")
    public String getEnergySummary(@PathVariable Long parkId) {
        return "Bendra energijos suvestinė parkui ID: " + parkId;
    }
}