package br.edu.infnet.appgabrielpereira.rest.controller;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
public class DebitCardController {

    @Autowired
    private DebitCardService debitCardService;

    @GetMapping(value = "debit-card/list")
    public Iterable<DebitCard> getAll() {
        return this.debitCardService.getAll();
    }

    @GetMapping(value = "debit-card/{id}")
    public DebitCard getById(@PathVariable int id) {
        return Objects.requireNonNull(this.debitCardService.getByKey(id), String.format("Debit card id: %d not found", id));
    }

    @PostMapping(value = "debit-card/create")
    public DebitCard create(@RequestBody DebitCard debitCard) {
        return this.debitCardService.add(debitCard);
    }

    @DeleteMapping(value = "debit-card/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.debitCardService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
