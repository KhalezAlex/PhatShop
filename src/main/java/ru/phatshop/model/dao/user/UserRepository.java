package ru.phatshop.model.dao.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phatshop.model.entities.User;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
    User findUserByUsername(String name);
}
