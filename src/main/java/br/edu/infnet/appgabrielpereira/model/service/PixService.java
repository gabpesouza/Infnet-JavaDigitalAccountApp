package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.repository.IPixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PixService {

    @Autowired
    private IPixRepository pixRepository;

    public Pix add(Pix pix) {
        return pixRepository.save(pix);
    }

    public Pix getByKey(Integer key) {
        return pixRepository.findById(key).orElse(null);
    }

    public Collection<Pix> getByKeyType(String keyType) {
        return pixRepository.findByKeyType(keyType);
    }

    public Iterable<Pix> getAll() {
        return pixRepository.findAll();
    }

    public Collection<Pix> findAllSortedByAmountDesc() {
        return pixRepository.findAll(Sort.by(Sort.Direction.DESC, "amount"));
    }

    public void remove(Integer key) {
       pixRepository.deleteById(key);
    }
}
