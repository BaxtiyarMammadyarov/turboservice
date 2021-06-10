package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value ="product",url = "http://localhost:8083/product")
public interface ProductClient {

    @GetMapping
    ResponseEntity<?> get();

    @PostMapping
    ResponseEntity<?> create(@RequestBody ProductDto product);

    @PutMapping
     ResponseEntity<?> update(@RequestBody ProductDto product);

    @DeleteMapping("/{id}")
     ResponseEntity<?> delete(@PathVariable("id") int id);
}
