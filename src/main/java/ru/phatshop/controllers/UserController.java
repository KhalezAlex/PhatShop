package ru.phatshop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.phatshop.encoder.PBFDK2Encoder;
import ru.phatshop.model.dao.user.UserService;
import ru.phatshop.model.entities.User;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/manager/create")
    public ResponseEntity<?> createManager(@RequestBody User user){
        service.saveManager(user);
        return ResponseEntity.ok("Продавец "+ user.getUsername() +" создан");
    }

    @GetMapping("/user/up")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateUser(){
        return ResponseEntity.ok("Done");
    }
}
