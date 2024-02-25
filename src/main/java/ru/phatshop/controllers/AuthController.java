package ru.phatshop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.phatshop.model.dto.JwtRequest;
import ru.phatshop.model.dto.UserDto;
import ru.phatshop.model.service.AuthService;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest){
        return service.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody UserDto userDto){
        return service.createNewUser(userDto);
    }

}
