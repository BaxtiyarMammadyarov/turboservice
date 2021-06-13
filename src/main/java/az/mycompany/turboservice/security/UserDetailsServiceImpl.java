package az.mycompany.turboservice.security;

import az.mycompany.turboservice.client.UserClient;
import az.mycompany.turboservice.dto.JwtResponse;
import az.mycompany.turboservice.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required = true)
    private UserClient client;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    public PasswordEncoder getEncoder() {
        return encoder;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = client.findUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setUsername(user.getUserName());
        userDetails.setPassword(user.getPassword());
        userDetails.setId(user.getId());
        return userDetails;

    }

    public ResponseEntity<?> register(UserDto user) {

        if (client.existsUsername(user.getUserName()).getBody()
                || client.existsEmail(user.getEmail()).getBody()
                || client.existsPinCode(user.getPin()).getBody()
                || client.existsPhone(user.getPhone()).getBody()) {
            throw new RuntimeException("username or email or fincode or phone  is already exsist");
        } else {

            user.setPassword(encoder.encode(user.getPassword()));

            client.create(user);
        }
        return ResponseEntity.ok("Sucses");
    }

    public ResponseEntity<JwtResponse> login(String username, String password) {
        log.info("loging started");
        UserDetailsImpl userDetails = loadUserByUsername(username);

        if (encoder.matches(password, userDetails.getPassword())) {

            log.info("correct password");

            Authentication authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(username, password));
            log.info("authentication");
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.generateJwtToken(authentication);
            log.info("create jwt");
            return ResponseEntity.ok(new JwtResponse(jwt));

        }
        {
            throw new RuntimeException("password incorrect!!!");
        }
    }

}
