package exception;


public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException ( Integer id) { super("User" , id);}
}
