package cat.itacademy.s04.t01.userapi.repository;

import cat.itacademy.s04.t01.userapi.models.User;

import java.util.*;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(UUID id);

    List<User> searchByName(String name);

    boolean existsByEmail(String email);

}
