package cat.itacademy.s04.t01.userapi.controller;


import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.s04.t01.userapi.exceptions.UserNotFoundException;


import java.util.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private static final List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return users;
        } else {
            String lowerName = name.toLowerCase();
            return users.stream()
                    .filter(u -> u.getName() != null && u.getName().toLowerCase().contains(lowerName))
                    .toList();
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User newUser) {
        newUser.setId(UUID.randomUUID());
        users.add(newUser);
        return newUser;
    }

    @GetMapping("/{id}")

    public User getUserById(@PathVariable UUID id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
