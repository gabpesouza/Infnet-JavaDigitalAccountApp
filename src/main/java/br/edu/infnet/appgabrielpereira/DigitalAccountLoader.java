package br.edu.infnet.appgabrielpereira;

import br.edu.infnet.appgabrielpereira.model.domain.DigitalAccount;
import br.edu.infnet.appgabrielpereira.model.domain.PaymentMethod;
import br.edu.infnet.appgabrielpereira.model.service.DigitalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@Component
@Order(1)
public class DigitalAccountLoader implements ApplicationRunner {

    @Autowired
    private DigitalAccountService service;

    @Override
    public void run(ApplicationArguments args) {

        try (FileReader reader = new FileReader("files/digitalaccount.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();

            Map<Integer, DigitalAccount> digitalAccounts = new HashMap<>();
            Map<Integer, List<PaymentMethod>> map = new HashMap<>();
            int digitalAccountIdCounter = 0;

            while (line != null) {
                Map<String, String> singleValueMap = UriComponentsBuilder.fromUriString(line).build().getQueryParams().toSingleValueMap();
                String typeData = singleValueMap.containsKey("digitalAccount") ? "digitalAccount" : "paymentMethod";
                DigitalAccount digitalAccount = null;


                switch (typeData) {
                    case "digitalAccount":
                        digitalAccount = new DigitalAccount(singleValueMap.get("digitalAccount"));
                        digitalAccount.setId(++digitalAccountIdCounter);
                        digitalAccounts.put(digitalAccount.getId(), digitalAccount);
                        map.put(digitalAccount.getId(), new ArrayList<PaymentMethod>());
                        break;
                    case "paymentMethod":
                        PaymentMethod paymentMethod = paymentMethodInstanceResolver(singleValueMap);
                        map.get(digitalAccountIdCounter).add(paymentMethod);
                        break;
                }

                line = br.readLine();
            }

            for (Map.Entry<Integer, List<PaymentMethod>> entries : map.entrySet()) {
                Integer digitalAccountId = entries.getKey();
                List<PaymentMethod> paymentMethods = entries.getValue();

                DigitalAccount digitalAccount = digitalAccounts.get(digitalAccountId);
                digitalAccount.setPaymentMethods(paymentMethods);
                service.add(digitalAccount);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static PaymentMethod paymentMethodInstanceResolver(Map<String, String> singleValueMap) {

        String paymentMethodType = singleValueMap.get("paymentMethod");

        switch (paymentMethodType) {
            case PaymentMethod.PIX_METHOD:
                return PixLoader.getPixData(singleValueMap);

            case PaymentMethod.CREDIT_METHOD:
                return CreditCardLoader.getCreditCardData(singleValueMap);

            case PaymentMethod.DEBIT_METHOD:
                return DebitCardLoader.getDebitCardData(singleValueMap);

            default:
                throw new IllegalArgumentException("This payment method doesnt exist.");
        }
    }
}
