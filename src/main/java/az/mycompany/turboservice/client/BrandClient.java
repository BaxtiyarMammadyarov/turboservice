package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.BrandDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "brand",url = "http://localhost:8083/brand")
public interface BrandClient {


    @PostMapping("/create")
    ResponseEntity<BrandDto> create(@RequestBody BrandDto brand) ;

    @GetMapping
    ResponseEntity<BrandDto> get();


    @DeleteMapping("/{id}")
     ResponseEntity<?> delete(@PathVariable int id) ;


    @PutMapping
    ResponseEntity<?> update(@RequestBody BrandDto brand) ;
}
