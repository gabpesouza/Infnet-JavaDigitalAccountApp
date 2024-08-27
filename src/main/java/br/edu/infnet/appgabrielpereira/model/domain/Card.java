package br.edu.infnet.appgabrielpereira.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Card extends PaymentMethod {

    @Column(name = "card_number", unique = true)
    protected String number;
    protected String securityCode;
    protected LocalDate expirationDate;
    protected String holderName;

    public Card() {
    }

    public Card(String currency,
                double fee,
                double amount,
                boolean isActive,
                String number,
                String securityCode,
                LocalDate expirationDate,
                String holderName
    ) {
        super(currency, fee, amount, isActive);
        this.number = number;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.holderName = holderName;
    }

    public String getNumber() {
        return number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
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
