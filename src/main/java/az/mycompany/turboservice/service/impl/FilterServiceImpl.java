package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.FilterClient;
import az.mycompany.turboservice.dto.SearchDto;
import az.mycompany.turboservice.service.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class FilterServiceImpl implements FilterService {

    private final FilterClient service;

    public FilterServiceImpl(FilterClient service) {
        this.service = service;
    }


    public ResponseEntity<?> getProduct(String brandName, String modelName, BigDecimal minPrice, BigDecimal maxPrice, Short minYear, Short maxYear, String cityName) {

        return service.getSearch( brandName,  modelName,  minPrice,  maxPrice,  minYear,  maxYear,  cityName);
    }


    public ResponseEntity<?> search(SearchDto dto) {

        return service.search(dto);
    }


}

