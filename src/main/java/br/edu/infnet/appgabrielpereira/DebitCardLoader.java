package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.DebitCard;
import br.edu.infnet.appgabrielpereira.model.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
public class DebitCardLoader implements ApplicationRunner {

    @Autowired
    private DebitCardService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (FileReader reader = new FileReader("files/debitcard.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while (line != null) {
                String[] debitCardData = line.split("/");
                DebitCard debitCard = getDebitCardData(debitCardData);
                this.service.add(debitCard);
                line = br.readLine();
            }

            for (DebitCard debitCard : this.service.getAll().values()) {
                System.out.println(debitCard);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static DebitCard getDebitCardData(String[] debitCardData) {

        return new DebitCard(
                debitCardData[0],
                Double.parseDouble(debitCardData[1]),
                Double.parseDouble(debitCardData[2]),
                Boolean.parseBoolean(debitCardData[3]),
                debitCardData[4],
                debitCardData[5],
                LocalDate.parse(debitCardData[6]),
                debitCardData[7],
                Double.parseDouble(debitCardData[8]),
                Double.parseDouble(debitCardData[9])
        );
    }
}
