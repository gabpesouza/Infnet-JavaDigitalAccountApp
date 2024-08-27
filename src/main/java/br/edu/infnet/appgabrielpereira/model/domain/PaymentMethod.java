package br.edu.infnet.appgabrielpereira.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentMethod {
    public static final String PIX_METHOD = "Pix";
    public static final String CREDIT_METHOD = "CreditCard";
    public static final String DEBIT_METHOD = "DebitCard";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String currency;
    protected Double fee;
    protected double amount;
    protected boolean isActive;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "digital_account_id")
    protected DigitalAccount digitalAccount;

    public PaymentMethod() {
    }

    public PaymentMethod(String currency, double fee, double amount, boolean isActive) {
        this.currency = currency;
        this.fee = fee;
        this.amount = amount;
        this.isActive = isActive;
    }

    protected String getCurrency() {
        return currency;
    }

    protected double getFee() {
        return fee;
    }

    protected double getAmount() {
        return amount;
    }

    protected boolean isActive() {
        return isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DigitalAccount getDigitalAccount() {
        return digitalAccount;
    }

    public void setDigitalAccount(DigitalAccount digitalAccount) {
        this.digitalAccount = digitalAccount;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "currency='" + currency + '\'' +
                ", fee=" + fee +
                ", amount=" + amount +
                ", isActive=" + isActive +
                ", DigitalAccount=" + digitalAccount +
                '}';
    }
}
