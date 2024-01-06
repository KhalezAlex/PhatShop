package ru.phatshop.model.dao;

import org.springframework.data.repository.CrudRepository;
import ru.phatshop.model.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
    User findUserByUsername(String name);
}
