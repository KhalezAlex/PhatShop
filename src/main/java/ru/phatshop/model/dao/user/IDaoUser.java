package ru.phatshop.model.dao.user;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import ru.phatshop.model.dao.IDaoDB;
import ru.phatshop.model.dto.UserDto;
import ru.phatshop.model.entities.User;

import java.util.Optional;
@Transactional
public interface IDaoUser extends IDaoDB<User> {
    Optional<User> findUserByName(String name);
    User findUserByUsername(String name);
    void saveAdmin(User user);
    void saveManager(User user);
}
