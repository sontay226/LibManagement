package Repository.Interface;
import Entities.User;
import java.util.List;
public interface IUserRepository extends GenericRepository<User , Integer> {
    List<User> findUserByName ( String name );
}
