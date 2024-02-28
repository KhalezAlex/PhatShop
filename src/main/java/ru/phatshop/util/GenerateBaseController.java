package ru.phatshop.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.phatshop.model.dao.user.IDaoUser;
import ru.phatshop.model.dao.user.UserService;
import ru.phatshop.model.dto.UserDto;
import ru.phatshop.model.entities.Role;
import ru.phatshop.model.entities.User;
import ru.phatshop.model.service.AuthService;

import java.io.IOException;

@Controller
@RequestMapping(path = "/service")
@RequiredArgsConstructor
public class GenerateBaseController {

    private final UserService user;
    private final AuthService service;

    @GetMapping("/generate")
    public String generate() throws IOException {
        testUsersInit();
//        UsersInit();
        return "redirect:/";
    }
    private void testUsersInit() {
        if (user.findUserByUsername("admin") != null)
            return;
        user.saveAdmin(new User("admin", "admin"));
        user.saveManager(new User("manager", "manager"));
        user.save(new User("user", "user", Role.USER));
    }

//    private void UsersInit() {
//        service.createNewAdmin(new UserDto("admin", "admin", "admin"));
//        service.createNewManager(new UserDto("manager", "manager", "manager"));
//        service.createNewUser(new UserDto("user", "user", "user"));
//    }

}
