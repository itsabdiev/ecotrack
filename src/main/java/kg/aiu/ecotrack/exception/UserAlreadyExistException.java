package kg.aiu.ecotrack.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super("User already exists");
    }
}
