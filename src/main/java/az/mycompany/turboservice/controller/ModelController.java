package az.mycompany.turboservice.controller;

import az.mycompany.turboservice.dto.ModelDto;
import az.mycompany.turboservice.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/model")
public class ModelController {

    private final ModelService service;


    public ModelController(ModelService modelService) {
        this.service = modelService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDto model) {

        return service.create(model);
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
    public ResponseEntity<?> update(@RequestBody ModelDto model) {
        return service.update(model);
    }
}
