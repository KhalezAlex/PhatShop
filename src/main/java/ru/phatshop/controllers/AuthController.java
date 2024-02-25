package ru.phatshop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.phatshop.model.dto.JwtRequest;
import ru.phatshop.model.dto.UserDto;
import ru.phatshop.model.service.AuthService;
import java.io.IOException;

@RestController
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

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getTableImageFile() throws IOException {
//        String imageStr = "C:/Users/svytk/OneDrive/Рабочий стол/photo_2023-04-16_16-36-25.jpg";
        String imageStr = "C:/Users/svytk/OneDrive/Рабочий%20стол/photo_2023-04-16_16-36-25.jpg";
//        String imageStr = "https://disk.yandex.ru/i/N_HWMEF5XwYs7Q";
        byte[] imageFile = imageStr.getBytes();
        return ResponseEntity.ok(imageFile);
}

}
