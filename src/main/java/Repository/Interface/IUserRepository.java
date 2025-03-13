package Repository.Interface;
import Entities.User;
public interface IUserRepository {
    boolean updateUser ( User newUser );
    boolean addUser ( User newUser );
    void findUserByName ( String name );
    void findUserById ( int id);
}
