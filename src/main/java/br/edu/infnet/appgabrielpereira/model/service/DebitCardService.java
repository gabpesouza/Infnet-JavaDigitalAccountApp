package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DebitCardService {

    private Map<Integer, DebitCard> debitCards = new HashMap<>();
    private Integer debitCardId = 0;

    public void add(DebitCard debitCard) {
        debitCard.setId(this.incrementPaymentGatewayId());
        debitCards.put(debitCard.getId(), debitCard);
    }

    public DebitCard getByKey(Integer key) {
        return this.debitCards.get(key);
    }

    public Map<Integer, DebitCard> getAll() {
        return this.debitCards;
    }

    public Integer getDebitCardId() {
        return debitCardId;
    }

    public Integer incrementPaymentGatewayId() {
        return ++this.debitCardId;
    }
}
