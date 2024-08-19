package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.PaymentGateway;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentGatewayService {

    private Map<Integer, PaymentGateway> gateways = new HashMap<>();
    private Integer paymentGatewayId = 0;

    public void add(PaymentGateway gateway) {
        gateway.setId(this.incrementPaymentGatewayId());
        gateways.put(gateway.getId(), gateway);
    }

    public PaymentGateway getByKey(Integer key) {
        return this.gateways.get(key);
    }

    public Map<Integer, PaymentGateway> getAll() {
        return this.gateways;
    }

    public Integer getPaymentGatewayId() {
        return paymentGatewayId;
    }

    public Integer incrementPaymentGatewayId() {
        return ++this.paymentGatewayId;
    }
}
