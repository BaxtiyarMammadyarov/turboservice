package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.FuelTypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "fueltype",url = "http://localhost:8083/fuel_type")
public interface FuelTypeClient {
    @PostMapping
   ResponseEntity<?> create(@RequestBody FuelTypeDto dto);

    @GetMapping
     ResponseEntity<?> get();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable int id) ;

    @PutMapping
    ResponseEntity<?> update(@RequestBody FuelTypeDto dto) ;
}
