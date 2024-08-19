package br.edu.infnet.appgabrielpereira.controller;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
public class PixController {

    @Autowired
    private PixService pixService;

    @GetMapping(value = "pix/list")
    public Collection<Pix> getAll() {
        return this.pixService.getAll().values();
    }

    @GetMapping(value = "pix/{id}")
    public Pix getById(@PathVariable int id) {
        return Objects.requireNonNull(this.pixService.getByKey(id), "Element not found in this map");
    }

    @PostMapping(value = "pix/create")
    public Pix create(@RequestBody Pix pix) {
        this.pixService.add(pix);
        return this.pixService.getByKey(this.pixService.getPixId());
    }

    @DeleteMapping(value = "pix/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.pixService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
