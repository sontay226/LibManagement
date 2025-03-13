package Repository.Interface;
import Entities.User;
public interface IUserRepository {
    boolean UpdateUser ( User newUser );
    boolean AddUser ( User newUser );
    void FindUserByName ( String name );
    void FindUserById ( int id);
}
