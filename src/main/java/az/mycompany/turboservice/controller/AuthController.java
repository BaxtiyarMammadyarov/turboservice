package az.mycompany.turboservice.controller;

import az.mycompany.turboservice.dto.JwtRequest;

import az.mycompany.turboservice.dto.UserDto;

import az.mycompany.turboservice.security.UserDetailsServiceImpl;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserDetailsServiceImpl userDetailsService;


    public AuthController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody JwtRequest jwtRequest) {
        return userDetailsService.login(jwtRequest.getUsername(), jwtRequest.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto) {

        return userDetailsService.register(userDto);
    }
}

