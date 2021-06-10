package az.mycompany.turboservice.service;


import az.mycompany.turboservice.dto.CityDto;
import org.springframework.stereotype.Service;

@Service
public interface CityService extends CrudService<CityDto,Integer> {
}
