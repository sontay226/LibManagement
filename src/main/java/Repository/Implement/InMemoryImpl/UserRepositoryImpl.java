package Repository.Implement.InMemoryImpl;

import Entities.User;
import Repository.Interface.IUserRepository;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements IUserRepository {
    private final Map<Integer , User> _userList = new HashMap<>();
    public UserRepositoryImpl ( Map<Integer,User> userList ) { if ( userList != null ) _userList.putAll(userList);}

    @Override
    public List<User> findUserByName(String name) {
        return _userList.values().stream().filter( u -> u.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Integer id) {
        return _userList.values().stream().filter( u -> u.getId() == id).findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(_userList.values());
    }

    @Override
    public User save(User newUser) {
        return _userList.put( newUser.getId() , newUser);
    }

    @Override
    public void deleteById(Integer id ) {
        if ( !_userList.containsKey(id)) throw new NoSuchElementException("This User Id : " + id + " is not exist!");
        _userList.remove(id);
    }
}
