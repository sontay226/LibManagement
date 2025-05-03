package Services;

import Entities.ReturnAndFee;
import Repository.Interface.IReturnAndFeeRepository;

import java.util.List;
import java.util.Optional;
import exception.ReturnAndFeeException;
public class ReturnAndFeeService {
    private final IReturnAndFeeRepository _returnAndFeeRepository;

    public ReturnAndFeeService(IReturnAndFeeRepository repo) {
        this._returnAndFeeRepository = repo;
    }

    public double calculateLateFee(ReturnAndFee returnAndFee) {
        if (returnAndFee == null) throw new ReturnAndFeeException("Return and fee must not be null!");
        return _returnAndFeeRepository.calLateFee(returnAndFee);
    }

    public void save(ReturnAndFee returnAndFee) {
        if (returnAndFee == null) throw new ReturnAndFeeException("ReturnAndFee must not be null");
        _returnAndFeeRepository.save(returnAndFee);
    }

    public ReturnAndFee findByUserId(int userId) {
        if ( userId <= 0 ) throw new IllegalArgumentException("User id must greater than 0");
        return _returnAndFeeRepository.findByUserId(userId).orElseThrow(() -> new ReturnAndFeeException("No return record for this user id : " + userId));
    }

    public List<ReturnAndFee> findAllReturns() {
        return _returnAndFeeRepository.findAll();
    }
}
