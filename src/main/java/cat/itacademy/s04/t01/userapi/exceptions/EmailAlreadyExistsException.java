package cat.itacademy.s04.t01.userapi.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("A user with email '" + email + "' already exists.");
    }
}

