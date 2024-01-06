package ru.phatshop.model.dao;

import ru.phatshop.model.entities.User;

import java.util.Optional;

public interface IDaoUser extends IDaoDB<User> {
    Optional<User> findUserByName(String name);
    User findUserByUsername(String name);
    void saveAdmin(User user);
}
