package br.edu.infnet.appgabrielpereira.model.repository;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IPixRepository extends CrudRepository<Pix, Integer> {

    Collection<Pix> findByKeyType(String keyType);

    Collection<Pix> findAll(Sort sort);
}
