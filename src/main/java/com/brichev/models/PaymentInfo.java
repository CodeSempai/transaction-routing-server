package com.brichev.models;


public class PaymentInfo {

    private CardForm card;

    private int amount;

    private String currency;

    private String merchantId;

    public CardForm getCard() {
        return card;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCard(CardForm card) {
        this.card = card;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}