package Repository.Implement.InMemoryImpl;

import Entities.User;
import Repository.Interface.IUserRepository;

import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private List<User> _list;
    public UserRepositoryImpl ( List<User> list ) { _list = list;}
    @Override
    public boolean updateUser(int id , String name , String address , String phoneNumber ) {
        for ( User tmp : _list ) {
            if ( tmp.getId() == id ) {
                tmp.setName(name);
                tmp.setAddress(address);
                tmp.setPhoneNumber(phoneNumber);
                System.out.println("Update User success!");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addUser(User newUser) {
        for ( User tmp : _list ) {
            if ( tmp.getId() == newUser.getId() ) {
                System.out.println("This ID already added!");
                return false;
            }
        }
        return _list.add(newUser);
    }

    @Override
    public void findUserByName(String name) {
        for ( User tmp : _list ) {
            if ( tmp.getName().equals(name) ) {
                System.out.println(tmp);
                return;
            }
        }
        System.out.println("User not found by name : " + name);
    }

    @Override
    public void findUserById( int id) {
        for ( User tmp : _list ) {
            if ( tmp.getId() == id ) {
                System.out.println(tmp);
                return;
            }
        }
        System.out.println("User not found by id : " + id );
    }
    public List<User> listUser () { return _list;}
}
