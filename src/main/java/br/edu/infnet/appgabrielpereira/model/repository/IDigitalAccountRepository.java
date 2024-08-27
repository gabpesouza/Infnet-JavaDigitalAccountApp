package br.edu.infnet.appgabrielpereira.model.repository;

import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import org.springframework.data.repository.CrudRepository;

public interface IDigitalAccountRepository extends CrudRepository<DigitalAccount, Integer> {

    DigitalAccount findTopByOrderByIdDesc();
}
