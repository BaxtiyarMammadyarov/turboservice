package az.mycompany.turboservice.service;


import az.mycompany.turboservice.dto.ContactInfoDto;
import org.springframework.stereotype.Service;


@Service
public interface ContactInfoService extends CrudService<ContactInfoDto,Integer> {
}
