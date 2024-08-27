package br.edu.infnet.appgabrielpereira.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "debitCardId")
public class DebitCard extends Card {

    public static final String DEFAULT_CURRENCY = "BRL";
    public static final double DEFAULT_FEE = 0.0;
    public static final double DEFAULT_DAILY_WITHDRAWAL_LIMIT = 1000.0;
    public static final double DEFAULT_OVERDRAFT_LIMIT = 2000.0;

    private double dailyWithdrawalLimit;
    private double overdraftLimit;

    public DebitCard() {
    }

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

    public double getAmount() {
        return this.amount;
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
