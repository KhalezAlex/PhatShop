package ru.phatshop.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.phatshop.encoder.PBFDK2Encoder;
import ru.phatshop.exeption.AuthError;
import ru.phatshop.jwt.JwtTokenUtils;
import ru.phatshop.model.dao.user.UserService;
import ru.phatshop.model.dto.JwtRequest;
import ru.phatshop.model.dto.JwtResponse;
import ru.phatshop.model.dto.UserDto;
import ru.phatshop.model.entities.Role;
import ru.phatshop.model.entities.User;

/**
 * Создание пользователей и токенов авторизации
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserService service;
    private final JwtTokenUtils jwt;
    private final AuthenticationManager authenticationManager;
    private final PBFDK2Encoder encoder;

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(new AuthError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = service.findUserByUsername(authRequest.getUsername());
        String token = jwt.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody UserDto UserDto){
        if (!UserDto.getPassword().equals(UserDto.getConfirmPassword())){
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if(service.findUserByName(UserDto.getUsername()).isPresent()){
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = User.builder()
                .username(UserDto.getUsername())
                .password(encoder.encode(UserDto.getPassword()))
                .role(Role.USER)
//                .role(Role.valueOf(UserDto.getRole()))
                .build();
        service.save(user);
        return ResponseEntity.ok("Пользователь "+ UserDto.getUsername() +" создан");
    }

    public ResponseEntity<?> createNewManager(@RequestBody UserDto UserDto){
        if (!UserDto.getPassword().equals(UserDto.getConfirmPassword())){
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if(service.findUserByName(UserDto.getUsername()).isPresent()){
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = User.builder()
                .username(UserDto.getUsername())
                .password(encoder.encode(UserDto.getPassword()))
                .role(Role.SELLER)
                .build();
        service.save(user);
        return ResponseEntity.ok("Пользователь "+ UserDto.getUsername() +" создан");
    }

    public ResponseEntity<?> createNewAdmin(@RequestBody UserDto UserDto){
        if (!UserDto.getPassword().equals(UserDto.getConfirmPassword())){
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if(service.findUserByName(UserDto.getUsername()).isPresent()){
            return new ResponseEntity<>(new AuthError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = User.builder()
                .username(UserDto.getUsername())
                .password(encoder.encode(UserDto.getPassword()))
                .role(Role.ADMIN)
                .build();
        service.save(user);
        return ResponseEntity.ok("Пользователь "+ UserDto.getUsername() +" создан");
    }
}
