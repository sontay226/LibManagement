package Repository.Implement.InMemoryImpl;

import Entities.Borrow;
import Entities.ReturnAndFee;
import Repository.Interface.IReturnAndFeeRepository;

import java.time.temporal.ChronoUnit;

public class ReturnAndFeeRepositoryImpl implements IReturnAndFeeRepository {
    private Borrow borrow;
    @Override
    public double calLateFee (ReturnAndFee returnAndFee) {
        long days = ChronoUnit.DAYS.between( borrow.getReturnExpectedDate() , returnAndFee.getReturnDate());
        if ( days > 0 ) {
            return days * returnAndFee.getLateFeePerDay();
        }
        if ( borrow.getReturnExpectedDate().isBefore(returnAndFee.getReturnDate()) || borrow.getReturnExpectedDate().isEqual(returnAndFee.getReturnDate())) {
            return returnAndFee.getFeePerDay()*days;
        }
        return 0;
    }
}
