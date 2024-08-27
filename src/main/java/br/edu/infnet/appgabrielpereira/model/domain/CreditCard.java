package br.edu.infnet.appgabrielpereira.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "creditCardId")
public class CreditCard extends Card {

    public static final String DEFAULT_CURRENCY = "BRL";
    public static final double DEFAULT_FEE = 0.0;
    public static final double DEFAULT_LIMIT = 5000.0;
    public static final double DEFAULT_INTEREST_RATE = 1.5;

    @Column(name = "monthly_limit")
    private double limit;
    private double interestRate;

    public CreditCard() {

    }

    public CreditCard(String currency,
                      double fee,
                      double amount,
                      boolean isActive,
                      String number,
                      String securityCode,
                      LocalDate expirationDate,
                      String holderName,
                      double limit,
                      double interestRate
    ) {
        super(currency, fee, amount, isActive, number, securityCode, expirationDate, holderName);
        this.limit = limit;
        this.interestRate = interestRate;
    }

    public double getLimit() {
        return limit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "limit=" + limit +
                ", interestRate=" + interestRate +
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
