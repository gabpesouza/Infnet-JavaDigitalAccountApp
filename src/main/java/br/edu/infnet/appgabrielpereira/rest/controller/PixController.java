package br.edu.infnet.appgabrielpereira.rest.controller;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
public class PixController {

    @Autowired
    private PixService pixService;

    @GetMapping(value = "pix/list")
    public Iterable<Pix> getAll() {
        return this.pixService.getAll();
    }

    @GetMapping(value = "pix/{id}")
    public Pix getById(@PathVariable int id) {
        return Objects.requireNonNull(this.pixService.getByKey(id), String.format("Pix id: %d not found", id));
    }

    @GetMapping(value = "pix/key-type/{keyType}")
    public Collection<Pix> getByKeyType(@PathVariable String keyType) {
        return pixService.getByKeyType(keyType.toUpperCase());
    }

    @GetMapping(value = "pix/amount/sorted")
    public Collection<Pix> getAllSortedByAmountDesc() {
        return pixService.findAllSortedByAmountDesc();
    }

    @PostMapping(value = "pix/create")
    public Pix create(@RequestBody Pix pix) {
        return this.pixService.add(pix);
    }

    @DeleteMapping(value = "pix/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.pixService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
