package Services;

import Entities.User;
import Repository.Interface.IUserRepository;

public class UserService {
    private IUserRepository userRepository;
    public UserService ( IUserRepository userRepository ) { this.userRepository = userRepository;}
    public boolean UdpateUser ( User newUser ) {
        if ( userRepository.UpdateUser(newUser)) return true;
        return false;
    }
    public boolean AddUser ( User newUser ) {
        if ( userRepository.AddUser(newUser)) return true;
        return false;
    }
    public void FindUserByName ( String name ) {
        userRepository.FindUserByName(name);
    }
    public void FindUserById ( int id ) {
        userRepository.FindUserById(id);
    }
}
