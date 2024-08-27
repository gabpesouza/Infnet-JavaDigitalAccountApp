package br.edu.infnet.appgabrielpereira.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DigitalAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String provider;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    @JoinColumn(name = "digital_account_id")
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public DigitalAccount(String name) {
        this.provider = name;
    }

    public DigitalAccount(String name, List<PaymentMethod> paymentMethods) {
        this(name);
        this.paymentMethods = paymentMethods;
    }

    public DigitalAccount() {}


    public String getProvider() {
        return provider;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "DigitalAccount{" +
                "provider='" + provider + '\'' +
                ", paymentMethods=" + paymentMethods +
                '}';
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
