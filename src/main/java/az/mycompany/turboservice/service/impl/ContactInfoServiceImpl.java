package az.mycompany.turboservice.service.impl;


import az.mycompany.turboservice.client.ContactInfoClient;
import az.mycompany.turboservice.dto.ContactInfoDto;
import az.mycompany.turboservice.service.ContactInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoClient service;

    public ContactInfoServiceImpl(ContactInfoClient service) {
        this.service = service;
    }

    public ResponseEntity<?> create(ContactInfoDto contact) {
        return service.create(contact);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {

        return service.delete(id);
    }

    @Override
    public ResponseEntity<?> update(ContactInfoDto contact) {
        return service.update(contact);
    }

    @Override
    public ResponseEntity<?> get() {

        return service.get();
    }


}

