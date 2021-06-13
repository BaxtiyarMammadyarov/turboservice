package az.mycompany.turboservice.controller;


import az.mycompany.turboservice.dto.FuelTypeDto;
import az.mycompany.turboservice.service.FuelTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fuel_type")
public class FuelTypeController {
    private final FuelTypeService service;

    public FuelTypeController(FuelTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FuelTypeDto dto) {

        return service.create(dto);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return service.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return service.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody FuelTypeDto dto) {
        return service.update(dto);
    }
}
