package Repository.Interface;

import java.util.Optional;
import java.util.List;
public interface GenericRepository<T , ID>{
    Optional<T> findById ( ID id);
    List<T> findAll();
    T save ( T entity);
    void deleteById ( ID id);
}
