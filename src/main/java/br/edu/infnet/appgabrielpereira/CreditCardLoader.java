package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.service.CreditCardService;
import br.edu.infnet.appgabrielpereira.model.service.DigitalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Component
public class CreditCardLoader implements ApplicationRunner {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private DigitalAccountService digitalAccountService;

    @Override
    public void run(ApplicationArguments args) {
        try (FileReader reader = new FileReader("files/creditcard.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while (line != null) {
                Map<String, String> singleValueMap = UriComponentsBuilder.fromUriString(line).build().getQueryParams().toSingleValueMap();
                int digitalAccountId = Integer.parseInt(singleValueMap.get("digitalAccountId"));
                DigitalAccount digitalAccount = Objects.requireNonNull(digitalAccountService.getByKey(digitalAccountId), String.format("Digital account id: %d not found", digitalAccountId));
                CreditCard creditCard = getCreditCardData(singleValueMap);
                creditCard.setDigitalAccount(digitalAccount);
                this.creditCardService.add(creditCard);
                line = br.readLine();
            }

            for (CreditCard creditCard : this.creditCardService.getAll()) {
                System.out.println(creditCard);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static CreditCard getCreditCardData(Map<String, String> singleValueMap) {
        return new CreditCard(
                singleValueMap.get("currency"),
                Double.parseDouble(singleValueMap.get("fee")),
                Double.parseDouble(singleValueMap.get("amount")),
                Boolean.parseBoolean(singleValueMap.get("isActive")),
                singleValueMap.get("number"),
                singleValueMap.get("securityCode"),
                LocalDate.parse(singleValueMap.get("expirationDate")),
                singleValueMap.get("holder"),
                Double.parseDouble(singleValueMap.get("limit")),
                Double.parseDouble(singleValueMap.get("interestRate"))
        );
    }
}
