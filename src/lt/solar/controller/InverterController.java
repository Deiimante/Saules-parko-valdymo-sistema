package lt.solar.controller;

import lt.solar.entity.Inverter;
import lt.solar.service.InverterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parks/{parkId}/inverters")
@CrossOrigin(origins = "*")
public class InverterController {

    private final InverterService service;

    public InverterController(InverterService service) {
        this.service = service;
    }

    @PostMapping
    public Inverter create(@PathVariable Long parkId, @RequestBody Inverter inverter) {
        return service.save(inverter);
    }

    @GetMapping
    public List<Inverter> getAll(@PathVariable Long parkId) {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Inverter getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Inverter update(@PathVariable Long id, @RequestBody Inverter inverter) {
        return service.update(id, inverter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}