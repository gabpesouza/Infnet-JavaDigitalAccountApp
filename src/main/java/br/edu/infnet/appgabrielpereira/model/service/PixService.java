package br.edu.infnet.appgabrielpereira.model.service;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PixService {

    private Map<Integer, Pix> pix = new HashMap<>();
    private Integer pixId = 0;

    public void add(Pix pix) {
        pix.setId(this.incrementPaymentGatewayId());
        this.pix.put(pix.getId(), pix);
    }

    public Pix getByKey(Integer key) {
        return this.pix.get(key);
    }

    public Map<Integer, Pix> getAll() {
        return this.pix;
    }

    public Integer getPixId() {
        return this.pixId;
    }

    public Integer incrementPaymentGatewayId() {
        return ++this.pixId;
    }

    public void remove(Integer key) {
        this.pix.remove(key);
    }
}
