package ru.phatshop.model.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.phatshop.model.entities.User;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IDaoUser{

    private final UserRepository repository;
    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(Integer id) {
        return null;
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public User findUserByUsername(String name) {
        return repository.findUserByUsername(name);
    }

    @Override
    public void saveAdmin(User user) {

    }

}
