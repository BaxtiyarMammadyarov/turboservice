package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.BrandClient;
import az.mycompany.turboservice.dto.BrandDto;
import az.mycompany.turboservice.service.BrandService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandClient service;

    public BrandServiceImpl(BrandClient service) {
        this.service = service;
    }

    public ResponseEntity<?> create(BrandDto brandDto) {
        System.out.println(brandDto);
        return ResponseEntity.ok(service.create(brandDto).getBody());
    }

    public ResponseEntity<?> delete(Integer id) {
        return service.delete(id);
    }

    @Override
    public ResponseEntity<?> update(BrandDto brandDto) {
        return service.update(brandDto);
    }

    @Override
    public ResponseEntity<?> get() {
        return service.get();
    }


}
