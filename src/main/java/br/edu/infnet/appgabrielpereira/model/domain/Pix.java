package br.edu.infnet.appgabrielpereira.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "pix_id")
public class Pix extends PaymentMethod{

    @Column(name = "pix_key")
    private String key;
    private String keyType;

    public Pix() {

    }

    public Pix(String currency, double fee, double amount, boolean isActive, String key, String keyType) {
        super(currency, fee, amount, isActive);
        this.key = key;
        this.keyType = keyType;
    }

    public String getKey() {
        return key;
    }

    public String getKeyType() {
        return keyType;
    }

    public double getAmount(){
        return this.amount;
    }

    @Override
    public String toString() {
        return "Pix{" +
                "key='" + key + '\'' +
                ", keyType='" + keyType + '\'' +
                ", currency='" + currency + '\'' +
                ", fee=" + fee +
                ", amount=" + amount +
                ", isActive=" + isActive +
                '}';
    }
}
