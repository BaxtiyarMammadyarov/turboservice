package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.CityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "city",url = "http://localhost:8083/city")
public interface CityClient {
    @PostMapping
     ResponseEntity<?> create(@RequestBody CityDto city) ;

    @GetMapping
    ResponseEntity<?> get();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable int id) ;

    @PutMapping
     ResponseEntity<?> update(@RequestBody CityDto city);

}
