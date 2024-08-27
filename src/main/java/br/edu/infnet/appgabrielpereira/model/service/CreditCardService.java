package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import br.edu.infnet.appgabrielpereira.model.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    public CreditCard add(CreditCard creditCard) {
        return this.creditCardRepository.save(creditCard);
    }

    public CreditCard getByKey(Integer key) {
        return this.creditCardRepository.findById(key).orElse(null);
    }

    public Iterable<CreditCard> getAll() {
        return this.creditCardRepository.findAll();
    }

    public void remove(int creditCardId) {
        this.creditCardRepository.deleteById(creditCardId);
    }
}
