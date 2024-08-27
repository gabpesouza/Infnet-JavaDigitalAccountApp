package br.edu.infnet.appgabrielpereira.web.controller;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import br.edu.infnet.appgabrielpereira.model.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/credit-card/web")
public class CreditCardWebController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    private String getAll(Model model) {

        Iterable<CreditCard> creditCardList = creditCardService.getAll();

        model.addAttribute("creditCardList", creditCardList);

        return "/creditCard/credit-card";
    }

    @GetMapping("/add")
    private String add() {

        return "/creditCard/add_credit_card";
    }

    @PostMapping("/create")
    private String create(
            @RequestParam double amount,
            @RequestParam String number,
            @RequestParam String securityCode,
            @RequestParam LocalDate expiration,
            @RequestParam String holderName,
            @RequestParam double limit,
            @RequestParam double interestRate
    ) {

        CreditCard creditCard = new CreditCard(
                CreditCard.DEFAULT_CURRENCY,
                CreditCard.DEFAULT_FEE,
                amount,
                true,
                number,
                securityCode,
                expiration,
                holderName,
                limit,
                interestRate
        );

        creditCardService.add(creditCard);

        return "redirect:/credit-card/web";
    }

    @GetMapping("/find")
    private String findById(@RequestParam int id, Model model) {
        CreditCard creditCard = this.creditCardService.getByKey(id);
        List<CreditCard> creditCardList = new ArrayList<>();

        if (creditCard != null) {
            creditCardList.add(creditCard);
            model.addAttribute("creditCardList", creditCardList);
        } else {
            String errorMessage = "Id " + id + " not found";
            model.addAttribute("errorMessage", errorMessage);
        }

        return "/creditCard/credit-card";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id) {
        this.creditCardService.remove(id);

        return "redirect:/credit-card/web";
    }
}
