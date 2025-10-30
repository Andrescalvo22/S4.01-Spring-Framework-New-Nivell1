package cat.itacademy.s04.t01.userapi.service;

import cat.itacademy.s04.t01.userapi.models.User;
import java.util.*;

public interface UserService {
    User createUser(User newUser);
    List<User> getAllUsers(String name);
    User getUserById(UUID id);
}
