package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.ProductClient;
import az.mycompany.turboservice.dto.ProductDto;
import az.mycompany.turboservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductClient service;

    public ProductServiceImpl(ProductClient service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<?> create(ProductDto productDto) {
        return service.create(productDto);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return service.delete(id);
    }

    @Override
    public ResponseEntity<?> get() {
        return service.get();
    }

    @Override
    public ResponseEntity<?> update(ProductDto productDto) {
        return service.update(productDto);
    }
}
