package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.FuelTypeClient;
import az.mycompany.turboservice.dto.FuelTypeDto;
import az.mycompany.turboservice.service.FuelTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FuelTypeServiceImle implements FuelTypeService {
    private final FuelTypeClient service;

    public FuelTypeServiceImle(FuelTypeClient service) {
        this.service = service;
    }

    public ResponseEntity<?> create(FuelTypeDto fuelTypeDto) {
        return service.create(fuelTypeDto);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return service.delete(id);
    }

    @Override
    public ResponseEntity<?> update(FuelTypeDto fuelTypeDto) {
        return service.update(fuelTypeDto);
    }

    @Override
    public ResponseEntity<?> get() {

        return service.get();
    }


}
