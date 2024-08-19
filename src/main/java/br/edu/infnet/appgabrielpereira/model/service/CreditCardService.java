package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CreditCardService {

    private Map<Integer, CreditCard> creditCards = new HashMap<>();
    private Integer CreditCardId = 0;

    public void add(CreditCard creditCard) {
        creditCard.setId(this.incrementCreditCardId());
        creditCards.put(creditCard.getId(), creditCard);
    }

    public CreditCard getByKey(Integer key) {
        return this.creditCards.get(key);
    }

    public Map<Integer, CreditCard> getAll() {
        return this.creditCards;
    }

    public Integer getCreditCardId() {
        return CreditCardId;
    }

    public Integer incrementCreditCardId() {
        return ++this.CreditCardId;
    }
}
