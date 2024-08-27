package br.edu.infnet.appgabrielpereira.web.controller;

import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.service.DigitalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/digital-account/web")
public class DigitalAccountWebController {

    @Autowired
    private DigitalAccountService digitalAccountService;

    @GetMapping
    private String getAll(Model model) {

        Iterable<DigitalAccount> pixList = digitalAccountService.getAll();

        model.addAttribute("digitalAccountList", pixList);

        return "/digitalAccount/digital-account";
    }

    @GetMapping("/add")
    private String add() {

        return "/digitalAccount/add_digital_account";
    }

    @PostMapping("/create")
    private String create(@RequestParam String provider) {

        DigitalAccount digitalAccount = new DigitalAccount(provider);

        digitalAccountService.add(digitalAccount);

        return "redirect:/digital-account/web";
    }

    @GetMapping("/find")
    private String findById(@RequestParam int id, Model model) {
        DigitalAccount digitalAccount = this.digitalAccountService.getByKey(id);
        List<DigitalAccount> digitalAccountList = new ArrayList<>();

        if (digitalAccount != null) {
            digitalAccountList.add(digitalAccount);
            model.addAttribute("digitalAccountList", digitalAccountList);
        } else {
            String errorMessage = "Id " + id + " not found";
            model.addAttribute("errorMessage", errorMessage);
        }

        return "/digitalAccount/digital-account";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id) {
        this.digitalAccountService.remove(id);

        return "redirect:/digital-account/web";
    }
}
