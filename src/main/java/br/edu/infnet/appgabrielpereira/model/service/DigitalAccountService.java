package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.repository.IDigitalAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DigitalAccountService {

    @Autowired
    private IDigitalAccountRepository digitalAccountRepository;

    public DigitalAccount add(DigitalAccount digitalAccount) {
        return this.digitalAccountRepository.save(digitalAccount);
    }

    public DigitalAccount getByKey(Integer key) {
        return this.digitalAccountRepository.findById(key).orElse(null);
    }

    public Iterable<DigitalAccount> getAll() {
        return this.digitalAccountRepository.findAll();
    }

    public void remove(int digitalAccountId){
        this.digitalAccountRepository.deleteById(digitalAccountId);
    }

    public DigitalAccount getLastInserted() {
        return this.digitalAccountRepository.findTopByOrderByIdDesc();
    }
}
