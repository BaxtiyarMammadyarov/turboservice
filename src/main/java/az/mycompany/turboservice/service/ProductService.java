package az.mycompany.turboservice.service;


import az.mycompany.turboservice.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends CrudService<ProductDto,Integer> {
}
