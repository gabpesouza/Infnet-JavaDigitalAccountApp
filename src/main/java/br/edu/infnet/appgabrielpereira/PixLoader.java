package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.service.DigitalAccountService;
import br.edu.infnet.appgabrielpereira.model.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;

@Component
public class PixLoader implements ApplicationRunner {

    @Autowired
    private PixService pixService;

    @Autowired
    private DigitalAccountService digitalAccountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (FileReader reader = new FileReader("files/pix.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while (line != null) {
                Map<String, String> singleValueMap = UriComponentsBuilder.fromUriString(line).build().getQueryParams().toSingleValueMap();
                int digitalAccountId = Integer.parseInt(singleValueMap.get("digitalAccountId"));
                DigitalAccount digitalAccount = Objects.requireNonNull(digitalAccountService.getByKey(digitalAccountId), String.format("Digital account id: %d not found", digitalAccountId));
                Pix pix = getPixData(singleValueMap);
                pix.setDigitalAccount(digitalAccount);
                this.pixService.add(pix);
                line = br.readLine();

            }

            for (Pix pix : this.pixService.getAll()) {
                System.out.println(pix);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Pix getPixData(Map<String, String> pixData) {
        return new Pix(
                pixData.get("currency"),
                Double.parseDouble(pixData.get("fee")),
                Double.parseDouble(pixData.get("amount")),
                Boolean.parseBoolean(pixData.get("isActive")),
                pixData.get("key"),
                pixData.get("keyType")
        );
    }
}
