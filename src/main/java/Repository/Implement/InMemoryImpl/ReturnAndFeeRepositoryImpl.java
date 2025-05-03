package Repository.Implement.InMemoryImpl;

import Entities.Borrow;
import Entities.ReturnAndFee;
import Repository.Interface.IReturnAndFeeRepository;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class ReturnAndFeeRepositoryImpl implements IReturnAndFeeRepository {
    private final Map<Integer, Borrow> borrowMap = new HashMap<>();
    private final List<ReturnAndFee> returnRecords = new ArrayList<>();

    public ReturnAndFeeRepositoryImpl(Map<Integer, Borrow> borrowData) {
        if (borrowData != null) {
            borrowMap.putAll(borrowData);
        }
    }

    @Override
    public double calLateFee(ReturnAndFee returnAndFee) {
        Borrow borrow = borrowMap.values().stream()
                .filter(b -> b.getBorrower().getId() == returnAndFee.getUserId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Borrow với userId = " + returnAndFee.getUserId()));

        long daysLate = ChronoUnit.DAYS.between(borrow.getReturnExpectedDate(), returnAndFee.getReturnDate());

        if (daysLate > 0) return daysLate * returnAndFee.getLateFeePerDay();
        return 0;
    }

    @Override
    public void save(ReturnAndFee returnAndFee) {
        returnRecords.add(returnAndFee);
    }

    @Override
    public List<ReturnAndFee> findAll() {
        return new ArrayList<>(returnRecords);
    }

    @Override
    public Optional<ReturnAndFee> findByUserId(int userId) {
        return returnRecords.stream()
                .filter(rf -> rf.getUserId() == userId)
                .findFirst();
    }
}
