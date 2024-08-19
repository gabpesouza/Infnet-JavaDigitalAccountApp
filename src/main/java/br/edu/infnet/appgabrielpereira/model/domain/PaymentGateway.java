package br.edu.infnet.appgabrielpereira.model.domain;

import java.util.ArrayList;
import java.util.List;

public class PaymentGateway {

    private int id;
    private String name;
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public PaymentGateway(String name) {
        this.name = name;
    }

    public PaymentGateway(String name, List<PaymentMethod> paymentMethods) {
        this(name);
        this.paymentMethods = paymentMethods;
    }


    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "PaymentGateway{" +
                "name='" + name + '\'' +
                ", paymentMethods=" + paymentMethods +
                '}';
    }
}
