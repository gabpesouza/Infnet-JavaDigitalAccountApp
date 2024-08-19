package br.edu.infnet.appgabrielpereira.controller;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import br.edu.infnet.appgabrielpereira.model.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping(value = "credit-card/list")
    public Collection<CreditCard> getAll() {
        return this.creditCardService.getAll().values();
    }

}
