package az.mycompany.turboservice.service.impl;//package az.mycompany.turboservice.service.impl;
//
//import az.mycompany.turboservice.dto.UserDto;
//import az.mycompany.turboservice.feignclient.UserClientService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	private final UserClientService service;
//	private final PasswordEncoder encoder;
//
//	public MyUserDetailsService(UserClientService service, PasswordEncoder encoder) {
//		this.service = service;
//		this.encoder = encoder;
//	}
//
//
//	public ResponseEntity<?> register(UserDto user) {
//
//		if (service.existsUsername(user.getUserName()).getBody()
//				|| service.existsEmail(user.getEmail()).getBody()
//				|| service.existsPinCode(user.getPin()).getBody()
//				|| service.existsPhone(user.getPhone()).getBody()) {
//			throw new RuntimeException("username or email or fincode or phone  is already exsist");
//		}else {
//			System.out.println(user+"\n");
//			user.setPassword(encoder.encode(user.getPassword()));
//			System.out.println(user+"\n");
//			service.create(user);
//		}
//		return ResponseEntity.ok("Sucses");
//	}
//	public UserDetails login(String username, String password){
//		System.out.println("login basladi username "+username+" password "+password);
//		if(service.existsUsername(username).getBody()){
//			User user = null;
//			UserDto userDto=service.findUsername(username).getBody();
//			System.out.println(userDto.getPassword()+" "+encoder.encode(password));
//			if(encoder.matches(password,userDto.getPassword())){
//				user= new User(userDto.getUserName(), userDto.getPassword(),new ArrayList<>());System.out.println(" login metod isledi "+user);
//				System.out.println("user yzrzdildi "+user);
//			}
//			return user;
//		}
//		else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println(" load by user basladi" );
//		if (service.existsUsername(username).getBody()) {
//			UserDto userDto=service.findUsername(username).getBody();
//			System.out.println(" user yaradildi" );
//			return new User(userDto.getUserName(), userDto.getPassword(),
//					new ArrayList<>());
//
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
//}