package br.edu.infnet.appgabrielpereira.rest.controller;

import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.service.DigitalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class DigitalAccountController {

    @Autowired
    private DigitalAccountService digitalAccountService;

    @GetMapping(value = "digital-account/list")
    public Iterable<DigitalAccount> getAll() {
        return this.digitalAccountService.getAll();
    }

    @GetMapping(value = "digital-account/{id}")
    public DigitalAccount getById(@PathVariable int id) {
        return Objects.requireNonNull(this.digitalAccountService.getByKey(id), String.format("Digital account id: %d not found", id));
    }

    @PostMapping(value = "digital-account/create")
    public DigitalAccount create(@RequestBody DigitalAccount digitalAccount) {
        return this.digitalAccountService.add(digitalAccount);
    }

    @DeleteMapping(value = "digital-account/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.digitalAccountService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
