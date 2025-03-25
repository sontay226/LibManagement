package Entities;

import java.time.LocalDate;

public class ReturnAndFee {
    private double LateFeePerDay , ReturnLateFee;
    private LocalDate ReturnDate;


    public ReturnAndFee(double lateFeePerDay, double returnLateFee, LocalDate returnDate) {
        LateFeePerDay = lateFeePerDay;
        ReturnLateFee = returnLateFee;
        ReturnDate = returnDate;
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
}
