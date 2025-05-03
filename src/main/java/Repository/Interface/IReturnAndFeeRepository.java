package Repository.Interface;

import Entities.ReturnAndFee;
import java.util.List;
import java.util.Optional;

public interface IReturnAndFeeRepository {
    double calLateFee(ReturnAndFee returnAndFee);
    void save(ReturnAndFee returnAndFee);
    List<ReturnAndFee> findAll();
    Optional<ReturnAndFee> findByUserId(int userId);
}
