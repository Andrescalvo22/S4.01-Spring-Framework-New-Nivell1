package cat.itacademy.s04.t01.userapi.service;

import cat.itacademy.s04.t01.userapi.exceptions.*;
import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User newUser) {
        if (repository.existsByEmail(newUser.getEmail())) {
            throw new EmailAlreadyExistsException(newUser.getEmail());
        }
        newUser.setId(UUID.randomUUID());
        return repository.save(newUser);
    }

    @Override
    public List<User> getAllUsers(String name) {
        return (name == null || name.isBlank())
                ? repository.findAll()
                : repository.searchByName(name);
    }

    @Override
    public User getUserById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
