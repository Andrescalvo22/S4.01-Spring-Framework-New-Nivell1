package cat.itacademy.s04.t01.userapi;

import cat.itacademy.s04.t01.userapi.controller.UserController;

import java.lang.reflect.Field;
import java.util.List;

public class UserControllerTestUtils {
    public static void clearUsers() {
        try {
            Field usersField = UserController.class.getDeclaredField("users");
            usersField.setAccessible(true);
            List<?> users = (List<?>) usersField.get(null);
            users.clear();
        } catch (Exception ignored) {}
    }
}

