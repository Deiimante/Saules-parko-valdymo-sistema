package lt.solar.controller;

import lt.solar.entity.SolarPark;
import lt.solar.service.SolarParkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parks")
public class SolarParkController {

    private final SolarParkService service;

    public SolarParkController(SolarParkService service) {
        this.service = service;
    }

    @PostMapping
    public SolarPark create(@RequestBody SolarPark park) {
        return service.create(park);
    }

    @GetMapping
    public List<SolarPark> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}