package lt.solar.controller;

import lt.solar.entity.EnergyReading;
import lt.solar.service.EnergyReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy")
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
}