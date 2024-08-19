package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.Pix;
import br.edu.infnet.appgabrielpereira.model.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class PixLoader implements ApplicationRunner {

    @Autowired
    private PixService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (FileReader reader = new FileReader("files/pix.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while (line != null) {
                String[] pixData = line.split("/");
                Pix pix = getPixData(pixData);
                this.service.add(pix);
                line = br.readLine();
            }

            for (Pix pix : this.service.getAll().values()) {
                System.out.println(pix);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Pix getPixData(String[] pixData) {
        return new Pix(
                pixData[0],
                Double.parseDouble(pixData[1]),
                Double.parseDouble(pixData[2]),
                Boolean.parseBoolean(pixData[3]),
                pixData[4],
                pixData[5]
        );
    }
}
