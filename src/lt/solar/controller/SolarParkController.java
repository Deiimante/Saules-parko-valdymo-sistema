package lt.solar.controller;

import lt.solar.entity.SolarPark;
import lt.solar.service.SolarParkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solarparks")
@CrossOrigin(origins = "*")
public class SolarParkController {

    private final SolarParkService solarParkService;

    public SolarParkController(SolarParkService solarParkService) {
        this.solarParkService = solarParkService;
    }

    @PostMapping
    public SolarPark create(@RequestBody SolarPark solarPark) {
        return solarParkService.save(solarPark);
    }

    @GetMapping
    public List<SolarPark> getAll() {
        return solarParkService.getAll();
    }

    @GetMapping("/{id}")
    public SolarPark getById(@PathVariable Long id) {
        return solarParkService.getById(id);
    }

    @PutMapping("/{id}")
    public SolarPark update(@PathVariable Long id, @RequestBody SolarPark solarPark) {
        return solarParkService.update(id, solarPark);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        solarParkService.delete(id);
    }
    @GetMapping("/{id}/stats")
    public String getStats(@PathVariable Long id) {
        return "Statistika parkui ID: " + id;
    }
}