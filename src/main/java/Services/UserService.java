package Services;

import Entities.User;
import Repository.Interface.IUserRepository;
import exception.UserNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User newUser) {
        if (newUser == null) throw new UserNotFoundException(newUser.getId());
        if (newUser.getId() <= 0) throw new IllegalArgumentException("Id must be greater than 0");
        if (newUser.getName() == null || newUser.getName().isEmpty()) throw new IllegalArgumentException("Name mustn't be empty");
        return userRepository.save( newUser );
    }
    public Optional<User> findById ( Integer id ) {
        if ( id == null || id <= 0 ) throw new IllegalArgumentException("Id must not be null");
        return userRepository.findById(id);
    }
    public List<User> findAll ( ) { return userRepository.findAll(); }
    public List<User> findUserByName(String name) {
        if ( name == null || name.isEmpty() ) throw new IllegalArgumentException("Name must not be null");
        return userRepository.findUserByName(name);
    }
    public void deleteById ( Integer id ) {
        if ( id == null || id <= 0 ) throw new IllegalArgumentException("Id must not be null");
        userRepository.findById(id).orElseThrow( () -> new UserNotFoundException(( id)));
        userRepository.deleteById(id);
    }
}
