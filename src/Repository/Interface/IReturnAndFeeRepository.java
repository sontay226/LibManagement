package Repository.Interface;

import Entities.ReturnAndFee;

public interface IReturnAndFeeRepository {
    double calLateFee(ReturnAndFee returnAndFee);
}
