package Repository.Implement.InMemoryImpl;

import Entities.Borrow;
import Entities.ReturnAndFee;
import Repository.Interface.IReturnAndFeeRepository;

import java.time.temporal.ChronoUnit;

public class ReturnAndFeeRepositoryRepoImpl implements IReturnAndFeeRepository {
    private Borrow borrow;
    @Override
    public double calLateFee (ReturnAndFee returnAndFee) {
        long days = ChronoUnit.DAYS.between( borrow.getReturnExpectedDate() , returnAndFee.getReturnDate());
        if ( days > 0 ) {
            return days * returnAndFee.getLateFeePerDay();
        }
        return 0;
    }
}
