package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.ModelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "model",url = "http://localhost:8083/model")
public interface ModelClient {
    @PostMapping
     ResponseEntity<?> create(@RequestBody ModelDto model) ;

    @GetMapping
    ResponseEntity<?> get();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable int id) ;

    @PutMapping
    ResponseEntity<?> update(@RequestBody ModelDto model) ;
}
