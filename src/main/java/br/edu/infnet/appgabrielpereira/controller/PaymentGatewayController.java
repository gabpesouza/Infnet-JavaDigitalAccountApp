package br.edu.infnet.appgabrielpereira.controller;

import br.edu.infnet.appgabrielpereira.model.domain.PaymentGateway;
import br.edu.infnet.appgabrielpereira.model.service.PaymentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PaymentGatewayController {

    @Autowired
    private PaymentGatewayService paymentGatewayService;

    @GetMapping(value = "/list")
    public Collection<PaymentGateway> getAll() {
        return this.paymentGatewayService.getAll().values();
    }

}
