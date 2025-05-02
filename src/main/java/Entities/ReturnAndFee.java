package Entities;

import java.time.LocalDate;

public class ReturnAndFee {
    private double LateFeePerDay , ReturnLateFee , FeePerDay;
    private LocalDate ReturnDate;
    private int UserId;
    public ReturnAndFee( int userId , double lateFeePerDay, double returnLateFee, LocalDate returnDate , double feePerDay) {
        LateFeePerDay = lateFeePerDay;
        ReturnLateFee = returnLateFee;
        ReturnDate = returnDate;
        UserId = userId;
        FeePerDay = feePerDay;
    }

    public double getLateFeePerDay() {
        return LateFeePerDay;
    }

    public void setLateFeePerDay(double lateFeePerDay) {
        LateFeePerDay = lateFeePerDay;
    }

    public double getReturnLateFee() {
        return ReturnLateFee;
    }

    public void setReturnLateFee(double returnLateFee) {
        ReturnLateFee = returnLateFee;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        ReturnDate = returnDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public double getFeePerDay() {
        return FeePerDay;
    }

    public void setFeePerDay(double feePerDay) {
        FeePerDay = feePerDay;
    }
}
