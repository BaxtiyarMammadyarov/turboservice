package az.mycompany.turboservice.service;



import az.mycompany.turboservice.dto.SearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public interface FilterService {

    ResponseEntity<?> getProduct(String brandName,String modelName,
                                 BigDecimal minPrice,
                                 BigDecimal maxPrice,
                                 Short minYear,
                                 Short maxYear,
                                 String cityName );

    ResponseEntity<?>search(SearchDto dto);


}
