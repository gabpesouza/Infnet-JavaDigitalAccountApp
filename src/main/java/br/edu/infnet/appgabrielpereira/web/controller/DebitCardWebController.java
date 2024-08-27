package br.edu.infnet.appgabrielpereira.web.controller;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.service.DebitCardService;
import br.edu.infnet.appgabrielpereira.model.service.DigitalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/debit-card/web")
public class DebitCardWebController {

    @Autowired
    private DebitCardService debitCardService;

    @GetMapping
    private String getAll(Model model) {

        Iterable<DebitCard> debitCardList = debitCardService.getAll();

        model.addAttribute("debitCardList", debitCardList);

        return "/debitCard/debit-card";
    }

    @GetMapping("/add")
    private String add() {

        return "/debitCard/add_debit_card";
    }

    @PostMapping("/create")
    private String create(
            @RequestParam double amount,
            @RequestParam String number,
            @RequestParam String securityCode,
            @RequestParam LocalDate expiration,
            @RequestParam String holderName,
            @RequestParam double dailyWithdrawalLimit,
            @RequestParam double overdraftLimit
    ) {

        DebitCard debitCard = new DebitCard(
                DebitCard.DEFAULT_CURRENCY,
                DebitCard.DEFAULT_FEE,
                amount,
                true,
                number,
                securityCode,
                expiration,
                holderName,
                dailyWithdrawalLimit,
                overdraftLimit
        );

        debitCardService.add(debitCard);

        return "redirect:/debit-card/web";
    }

    @GetMapping("/find")
    private String findById(@RequestParam int id, Model model) {
        DebitCard debitCard = this.debitCardService.getByKey(id);
        List<DebitCard> debitCardList = new ArrayList<>();

        if (debitCard != null) {
            debitCardList.add(debitCard);
            model.addAttribute("debitCardList", debitCardList);
        } else {
            String errorMessage = "Id " + id + " not found";
            model.addAttribute("errorMessage", errorMessage);
        }

        return "/debitCard/debit-card";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id) {
        this.debitCardService.remove(id);

        return "redirect:/debit-card/web";
    }
}
