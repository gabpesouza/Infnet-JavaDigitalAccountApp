package br.edu.infnet.appgabrielpereira.rest.controller;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import br.edu.infnet.appgabrielpereira.model.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping(value = "credit-card/list")
    public Iterable<CreditCard> getAll() {
        return this.creditCardService.getAll();
    }

    @GetMapping(value = "credit-card/{id}")
    public CreditCard getById(@PathVariable int id) {
        return Objects.requireNonNull(this.creditCardService.getByKey(id), String.format("Credit card id: %d not found", id));
    }

    @PostMapping(value = "credit-card/create")
    public CreditCard create(@RequestBody CreditCard creditCard) {
        return this.creditCardService.add(creditCard);
    }

    @DeleteMapping(value = "credit-card/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.creditCardService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
