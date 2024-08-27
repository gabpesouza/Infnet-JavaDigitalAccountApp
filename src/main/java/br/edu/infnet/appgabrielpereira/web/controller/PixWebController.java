package br.edu.infnet.appgabrielpereira.web.controller;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pix/web")
public class PixWebController {

    @Autowired
    private PixService pixService;

    @GetMapping
    private String getAll(Model model) {

        Iterable<Pix> pixList = pixService.getAll();

        model.addAttribute("pixList", pixList);

        return "pix/pix";
    }

    @GetMapping("/add")
    private String add() {

        return "pix/add_pix";
    }

    @PostMapping("/createpix")
    private String create(@RequestParam String keyType,
                          @RequestParam String key,
                          @RequestParam double value) {

        Pix pix = new Pix("BRL", 0.0, value, true, key, keyType);

        pixService.add(pix);

        return "redirect:/pix/web";
    }

    @GetMapping("/find")
    private String findById(@RequestParam int id, Model model) {
        Pix pix = this.pixService.getByKey(id);
        List<Pix> pixList = new ArrayList<>();

        if (pix != null) {
            pixList.add(pix);
            model.addAttribute("pixList", pixList);
        } else {
            String errorMessage = "Id " + id + " not found";
            model.addAttribute("errorMessage", errorMessage);
        }

        return "pix/pix";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id) {
        this.pixService.remove(id);

        return "redirect:/pix/web";
    }
}
