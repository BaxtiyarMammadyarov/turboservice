package az.mycompany.turboservice.controller;

import az.mycompany.turboservice.dto.CityDto;
import az.mycompany.turboservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CityDto city) {

        return cityService.create(city);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(cityService.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return cityService.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CityDto city) {

        return cityService.update(city);
    }
}
