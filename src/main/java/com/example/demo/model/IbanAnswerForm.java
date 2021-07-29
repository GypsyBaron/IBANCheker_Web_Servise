package com.example.demo.model;

public class IbanAnswerForm {
    private String iban;
    private Boolean isCorrect;

    public IbanAnswerForm(String iban, Boolean isCorrect) {
        this.iban = iban;
        this.isCorrect = isCorrect;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
