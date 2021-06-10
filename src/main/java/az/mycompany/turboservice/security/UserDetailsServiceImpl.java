package az.mycompany.turboservice.security;

import az.mycompany.turboservice.client.UserClient;
import az.mycompany.turboservice.dto.JwtResponse;
import az.mycompany.turboservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required = true)
    private  UserClient client;
    @Autowired
    private PasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils jwtUtils;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = client.findUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);

    }
	public ResponseEntity<?> register(UserDto user) {
		System.out.println(user+"\n");

		if (client.existsUsername(user.getUserName()).getBody()
				|| client.existsEmail(user.getEmail()).getBody()
				|| client.existsPinCode(user.getPin()).getBody()
				|| client.existsPhone(user.getPhone()).getBody()) {
			throw new RuntimeException("username or email or fincode or phone  is already exsist");
		}else {
			System.out.println(user+"\n");
			user.setPassword(encoder.encode(user.getPassword()));
			System.out.println(user+"\n");
            client.create(user);
		}
		return ResponseEntity.ok("Sucses");
	}
    	public ResponseEntity<JwtResponse> login(String username, String password){
            UserDto user;
            user = client.findUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));
//			if(encoder.encode(password).equals(user.getPassword())){
				System.out.println(user);
			 System.out.println(password);

			 Authentication	authentication= authenticationManager.
					 authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtils.generateJwtToken(authentication);
				System.out.println(jwt);
				return ResponseEntity.ok(new JwtResponse(jwt));


//			throw new RuntimeException("password incoorect!!!");
		}

}
