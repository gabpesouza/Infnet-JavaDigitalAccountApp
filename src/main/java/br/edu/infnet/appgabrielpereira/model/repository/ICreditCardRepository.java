package br.edu.infnet.appgabrielpereira.model.repository;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface ICreditCardRepository extends CrudRepository<CreditCard, Integer> {

}
