package br.edu.infnet.appgabrielpereira.model.domain;

import java.time.LocalDate;

public class DebitCard extends Card {

    private double dailyWithdrawalLimit;
    private double overdraftLimit;


    public DebitCard(String currency,
                     double fee,
                     double amount,
                     boolean isActive,
                     String number,
                     String securityCode,
                     LocalDate expirationDate,
                     String holderName,
                     double dailyWithdrawalLimit,
                     double overdraftLimit
    ) {
        super(currency, fee, amount, isActive, number, securityCode, expirationDate, holderName);
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.overdraftLimit = overdraftLimit;
    }

    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "dailyWithdrawalLimit=" + dailyWithdrawalLimit +
                ", overdraftLimit=" + overdraftLimit +
                ", number='" + number + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", expirationDate=" + expirationDate +
                ", holderName='" + holderName + '\'' +
                ", currency='" + currency + '\'' +
                ", fee=" + fee +
                ", amount=" + amount +
                ", isActive=" + isActive +
                '}';
    }
}
