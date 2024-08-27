package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import br.edu.infnet.appgabrielpereira.model.repository.IDebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitCardService {

    @Autowired
    private IDebitCardRepository debitCardRepository;

    public DebitCard add(DebitCard debitCard) {
        return this.debitCardRepository.save(debitCard);
    }

    public DebitCard getByKey(Integer key) {
        return this.debitCardRepository.findById(key).orElse(null);
    }

    public Iterable<DebitCard> getAll() {
        return this.debitCardRepository.findAll();
    }

    public void remove(int id) {
        this.debitCardRepository.deleteById(id);
    }
}
