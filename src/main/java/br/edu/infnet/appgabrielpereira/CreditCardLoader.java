package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.CreditCard;
import br.edu.infnet.appgabrielpereira.model.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
public class CreditCardLoader implements ApplicationRunner {

    @Autowired
    private CreditCardService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (FileReader reader = new FileReader("files/creditcard.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while (line != null) {
                String[] creditCardData = line.split("/");
                CreditCard creditCard = getCreditCardData(creditCardData);
                this.service.add(creditCard);
                line = br.readLine();
            }

            for (CreditCard creditCard : this.service.getAll().values()) {
                System.out.println(creditCard);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static CreditCard getCreditCardData(String[] creditCardData) {
        return new CreditCard(
                creditCardData[0],
                Double.parseDouble(creditCardData[1]),
                Double.parseDouble(creditCardData[2]),
                Boolean.parseBoolean(creditCardData[3]),
                creditCardData[4],
                creditCardData[5],
                LocalDate.parse(creditCardData[6]),
                creditCardData[7],
                Double.parseDouble(creditCardData[8]),
                Double.parseDouble(creditCardData[9])
        );
    }
}
