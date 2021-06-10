package az.mycompany.turboservice.client;


import az.mycompany.turboservice.dto.JwtRequest;
import az.mycompany.turboservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(value = "user", url = "http://localhost:8083/user")
public interface UserClient {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody UserDto dto);

    @PostMapping("/finduser")
    ResponseEntity<?> findUser(JwtRequest request);

    @PostMapping("/findUsername")
    Optional<UserDto> findUsername(String username);
    @PostMapping("/existsEmail")
     ResponseEntity<Boolean> existsEmail(@RequestBody String email);
    @PostMapping("/existsUsername")
     ResponseEntity<Boolean> existsUsername(@RequestBody String username);
    @PostMapping("/existsPinCode")
     ResponseEntity<Boolean> existsPinCode(@RequestBody String pinCode);
    @PostMapping("/existsPhone")
    ResponseEntity<Boolean> existsPhone(String phone);

}
