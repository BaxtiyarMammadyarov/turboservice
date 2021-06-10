package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.ContactInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "contactinfo",url = "http://localhost:8083/contactinfo")
public interface ContactInfoClient {
    @PostMapping
    ResponseEntity<?> create(@RequestBody ContactInfoDto dto) ;

    @GetMapping
     ResponseEntity<?> get();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable int id) ;

    @PutMapping
   ResponseEntity<?> update(@RequestBody ContactInfoDto dto) ;
}
