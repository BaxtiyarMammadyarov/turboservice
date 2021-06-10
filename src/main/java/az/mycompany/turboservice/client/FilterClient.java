package az.mycompany.turboservice.client;

import az.mycompany.turboservice.dto.SearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value ="filter",url = "http://localhost:8083/filter")
public interface FilterClient {
    @GetMapping("/search")
    ResponseEntity<?> getSearch(
            @RequestParam(defaultValue =" ")String brandName,
            @RequestParam(defaultValue =" ") String modelName,
            @RequestParam (defaultValue =""+Double.MIN_VALUE) BigDecimal minPrice,
            @RequestParam(defaultValue =""+Double.MAX_VALUE) BigDecimal maxPrice,
            @RequestParam(defaultValue =""+Short.MIN_VALUE) Short minYear ,
            @RequestParam (defaultValue =""+Short.MAX_VALUE)Short maxYear,
            @RequestParam(defaultValue =" ") String cityName ) ;

    @PostMapping("/filtir")
     ResponseEntity<?> search(@RequestBody SearchDto dto);

}
