package Services;

import Entities.ReturnAndFee;
import Repository.Interface.IReturnAndFeeRepository;

public class ReturnAndFeeService {
    private IReturnAndFeeRepository returnAndFeeRepository;
    public ReturnAndFeeService ( IReturnAndFeeRepository returnAndFeeRepository ) { this.returnAndFeeRepository =
            returnAndFeeRepository;}
    public double calLateFee (ReturnAndFee returnAndFee ) {
        return returnAndFeeRepository.calLateFee(returnAndFee);
    }
}
