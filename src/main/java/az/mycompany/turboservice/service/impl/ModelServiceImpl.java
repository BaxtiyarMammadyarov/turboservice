package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.ModelClient;
import az.mycompany.turboservice.dto.ModelDto;
import az.mycompany.turboservice.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ModelServiceImpl implements ModelService {

    private final ModelClient service;

    public ModelServiceImpl(ModelClient service) {
        this.service = service;
    }

    public ResponseEntity<?> create(ModelDto modelDto) {
        return service.create(modelDto);
    }

    public ResponseEntity<?> delete(Integer id) {
        return service.delete(id);
    }

    public ResponseEntity<?> update(ModelDto modelDto) {
        return service.update(modelDto);
    }

    public ResponseEntity<?> get() {
        return service.get();
    }
}
