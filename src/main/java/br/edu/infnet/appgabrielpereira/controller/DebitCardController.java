package br.edu.infnet.appgabrielpereira.controller;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import br.edu.infnet.appgabrielpereira.model.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DebitCardController {

    @Autowired
    private DebitCardService debitCardService;

    @GetMapping(value = "debit-card/list")
    public Collection<DebitCard> getAll() {
        return this.debitCardService.getAll().values();
    }

}
