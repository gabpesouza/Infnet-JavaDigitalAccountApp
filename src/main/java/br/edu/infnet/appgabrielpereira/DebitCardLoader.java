package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.service.DebitCardService;
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
public class DebitCardLoader implements ApplicationRunner {

    @Autowired
    private DebitCardService debitCardService;

    @Autowired
    private DigitalAccountService digitalAccountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (FileReader reader = new FileReader("files/debitcard.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while (line != null) {
                Map<String, String> singleValueMap = UriComponentsBuilder.fromUriString(line).build().getQueryParams().toSingleValueMap();
                int digitalAccountId = Integer.parseInt(singleValueMap.get("digitalAccountId"));
                DigitalAccount digitalAccount = Objects.requireNonNull(digitalAccountService.getByKey(digitalAccountId), String.format("Digital account id: %d not found", digitalAccountId));
                DebitCard debitCard = getDebitCardData(singleValueMap);
                debitCard.setDigitalAccount(digitalAccount);
                this.debitCardService.add(debitCard);
                line = br.readLine();
            }

            for (DebitCard debitCard : this.debitCardService.getAll()) {
                System.out.println(debitCard);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static DebitCard getDebitCardData(Map<String, String> debitCardData) {

        return new DebitCard(
                debitCardData.get("currency"),
                Double.parseDouble(debitCardData.get("fee")),
                Double.parseDouble(debitCardData.get("amount")),
                Boolean.parseBoolean(debitCardData.get("isActive")),
                debitCardData.get("number"),
                debitCardData.get("securityCode"),
                LocalDate.parse(debitCardData.get("expirationDate")),
                debitCardData.get("holder"),
                Double.parseDouble(debitCardData.get("dailyWithdrawalLimit")),
                Double.parseDouble(debitCardData.get("overdraftLimit"))
        );
    }
}
