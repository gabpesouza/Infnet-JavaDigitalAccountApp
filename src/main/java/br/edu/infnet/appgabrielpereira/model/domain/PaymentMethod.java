package br.edu.infnet.appgabrielpereira.model.domain;

public class PaymentMethod {
    public static final String PIX_METHOD = "Pix";
    public static final String CREDIT_METHOD = "CreditCard";
    public static final String DEBIT_METHOD = "DebitCard";

    protected int id;
    protected String currency;
    protected double fee;
    protected double amount;
    protected boolean isActive;

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

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "currency='" + currency + '\'' +
                ", fee=" + fee +
                ", amount=" + amount +
                ", isActive=" + isActive +
                '}';
    }
}
