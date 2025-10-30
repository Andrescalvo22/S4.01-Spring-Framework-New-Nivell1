package cat.itacademy.s04.t01.userapi.repository;

import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new CopyOnWriteArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> searchByName(String name) {
        String lower = name.toLowerCase();
        return users.stream()
                .filter(user -> user.getName() != null && user.getName().toLowerCase().contains(lower))
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
