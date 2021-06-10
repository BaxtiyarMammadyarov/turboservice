package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.CityClient;
import az.mycompany.turboservice.dto.CityDto;
import az.mycompany.turboservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements CityService {

    private final CityClient service;

    public CityServiceImpl(CityClient service) {
        this.service = service;
    }

    public ResponseEntity<?> create(CityDto cityDto) {

        return service.create(cityDto);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {

        return service.delete(id);
    }

    @Override
    public ResponseEntity<?> update(CityDto cityDto) {

        return service.update(cityDto);
    }

    @Override
    public ResponseEntity<?> get() {
        return service.get();
    }


}
