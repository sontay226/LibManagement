package Repository.Implement;

import Entities.User;
import Repository.Interface.IUserRepository;

import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private List<User> _list;
    public UserRepositoryImpl ( List<User> list ) { _list = list;}
    @Override
    public boolean UpdateUser(User newUser) {
        for ( User tmp : _list ) {
            if ( tmp.getId() == newUser.getId() ) {
                tmp.setName(newUser.getName());
                tmp.setAddress(newUser.getAddress());
                tmp.setPhoneNumber(newUser.getPhoneNumber());
                System.out.println("Update User success!");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean AddUser(User newUser) {
        for ( User tmp : _list ) {
            if ( tmp.getId() == newUser.getId() ) {
                System.out.println("This ID already added!");
                return false;
            }
        }
        _list.add(newUser);
        return true;
    }

    @Override
    public void FindUserByName(String name) {
        for ( User tmp : _list ) {
            if ( tmp.getName() == name ) {
                tmp.toString();
                return;
            }
        }
        System.out.println("Find end with success!");
    }

    @Override
    public void FindUserById( int id) {
        for ( User tmp : _list ) {
            if ( tmp.getId() == id ) {
                tmp.toString();
                return;
            }
        }
        System.out.println("Find end with success!");
    }
    public List<User> listUser () { return _list;}
}
