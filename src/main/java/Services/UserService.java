package Services;

import Entities.User;
import Repository.Interface.IUserRepository;

public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean updateUser(int id , String name , String address , String phoneNumber) {
        return userRepository.updateUser(id , name , address , phoneNumber);
    }

    public boolean addUser(User newUser) {
        return userRepository.addUser(newUser);
    }

    public void findUserByName(String name) {
        userRepository.findUserByName(name);
    }

    public void findUserById(int id) {
        userRepository.findUserById(id);
    }
}
