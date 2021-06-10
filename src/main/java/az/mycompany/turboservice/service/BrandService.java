package az.mycompany.turboservice.service;


import az.mycompany.turboservice.dto.BrandDto;
import org.springframework.stereotype.Service;

@Service
public interface BrandService extends CrudService<BrandDto,Integer> {
}
