package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.PaymentGateway;
import br.edu.infnet.appgabrielpereira.model.domain.PaymentMethod;
import br.edu.infnet.appgabrielpereira.model.service.PaymentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class PaymentGatewayLoader implements ApplicationRunner {

    @Autowired
    private PaymentGatewayService service;

    @Override
    public void run(ApplicationArguments args) {

        try (FileReader reader = new FileReader("files/gateway.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            while(line != null) {
                String[] data = line.split(";");
                String[] typeData = data[0].split("-");
                String typeName = typeData[1];
                String type = typeData[0];
                PaymentGateway gateway;

                switch (type) {
                    case "gateway":
                        gateway = new PaymentGateway(typeName);
                        this.service.add(gateway);
                        break;
                    case "paymentMethod":
                        String[] paymentMethodData = line.split(";");
                        PaymentMethod paymentMethod = paymentMethodInstanceResolver(typeName, paymentMethodData[1].split("/"));
                        this.service.getByKey(this.service.getPaymentGatewayId()).addPaymentMethod(paymentMethod);
                        break;
                }

                line = br.readLine();
            }

            for (PaymentGateway gateway : this.service.getAll().values()) {
                System.out.println(gateway);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static PaymentMethod paymentMethodInstanceResolver(String paymentMethodType, String[] paymentMethodData) {

        switch (paymentMethodType) {
             case PaymentMethod.PIX_METHOD:
                 return PixLoader.getPixData(paymentMethodData);

            case PaymentMethod.CREDIT_METHOD:
                return CreditCardLoader.getCreditCardData(paymentMethodData);

            case PaymentMethod.DEBIT_METHOD:
                return DebitCardLoader.getDebitCardData(paymentMethodData);

            default: throw new IllegalArgumentException("This payment method doesnt exist.");
        }
    }
}
