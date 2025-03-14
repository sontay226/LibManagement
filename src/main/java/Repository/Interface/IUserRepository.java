package Repository.Interface;
import Entities.User;
public interface IUserRepository {
    boolean updateUser ( int id , String name , String address , String phoneNumber );
    boolean addUser ( User newUser );
    void findUserByName ( String name );
    void findUserById ( int id);
}
