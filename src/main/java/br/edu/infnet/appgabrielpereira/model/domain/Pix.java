package br.edu.infnet.appgabrielpereira.model.domain;

public class Pix extends PaymentMethod{

    private static final String PHONE_KEY_TYPE = "PHONE";
    private static final String EMAIL_KEY_TYPE = "EMAIL";
    private static final String CPF_KEY_TYPE = "CPF";
    private static final String CNPJ_KEY_TYPE = "CNPJ";


    private String key;
    private String keyType;

    public Pix(String currency, double fee, double amount, boolean isActive, String key, String keyType) {
        super(currency, fee, amount, isActive);
        this.key = key;
        this.keyType = keyType;
    }

    public String getKey() {
        return key;
    }

    public String getKeyType() {
        return keyType;
    }

    @Override
    public String toString() {
        return "Pix{" +
                "key='" + key + '\'' +
                ", keyType='" + keyType + '\'' +
                ", currency='" + currency + '\'' +
                ", fee=" + fee +
                ", amount=" + amount +
                ", isActive=" + isActive +
                '}';
    }
}
