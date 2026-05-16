package lt.solar.controller;

import lt.solar.entity.EnergyReading;
import lt.solar.service.EnergyReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy")
@CrossOrigin(origins = "*")
public class EnergyReadingController {

    private final EnergyReadingService energyReadingService;

    public EnergyReadingController(EnergyReadingService energyReadingService) {
        this.energyReadingService = energyReadingService;
    }

    @PostMapping
    public EnergyReading create(@RequestBody EnergyReading reading) {
        return energyReadingService.save(reading);
    }

    @GetMapping
    public List<EnergyReading> getAll() {
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
    @GetMapping("/monthly")
    public List<EnergyReading> getMonthly() {
        return energyReadingService.getAll();
    }
}