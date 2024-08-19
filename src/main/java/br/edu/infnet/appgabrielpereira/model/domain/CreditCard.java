package br.edu.infnet.appgabrielpereira.model.domain;

import java.time.LocalDate;

public class CreditCard extends Card {

    private double limit;
    private double interestRate;


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
