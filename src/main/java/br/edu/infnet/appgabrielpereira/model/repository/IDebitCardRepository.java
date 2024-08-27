package br.edu.infnet.appgabrielpereira.model.repository;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import org.springframework.data.repository.CrudRepository;

public interface IDebitCardRepository extends CrudRepository<DebitCard, Integer> {
}
