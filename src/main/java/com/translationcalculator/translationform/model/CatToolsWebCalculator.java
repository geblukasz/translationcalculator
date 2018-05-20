package com.translationcalculator.translationform.model;

import com.translationcalculator.translationform.Utils.Variables;
import com.translationcalculator.translationform.calculator.Calculator;
import com.translationcalculator.translationform.calculator.CatToolsCalculator;
import com.translationcalculator.translationform.calculator.StandardCalculator;
import lombok.Setter;

import static com.translationcalculator.translationform.Utils.Variables.*;

public class CatToolsWebCalculator {


    @Setter
    private String translationType;
    private int signsNumber;
    private Calculator calculator;
    @Setter
    private String vatPayer;
    private boolean isVatPayer;
    private int numberOfNoMatchWords;
    private int numberOf75to99PercentMatchWords;
    private int numberOf100PercentMatchWords;


    double priceForNoMatchWords;
    double priceFor75to99MatchWords;
    double priceFor100MatchWords;
    double totalPrice;
    double taxPrice = totalPrice * Variables.TAX;

    public void setPriceForNoMatchWords(double priceForNoMatchWords) {
        this.priceForNoMatchWords = priceForNoMatchWords;
    }

    public void setPriceFor75to99MatchWords(double priceFor75to99MatchWords) {
        this.priceFor75to99MatchWords = priceFor75to99MatchWords;
    }

    public void setPriceFor100MatchWords(double priceFor100MatchWords) {
        this.priceFor100MatchWords = priceFor100MatchWords;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTaxPrice(double taxPrice) {
        this.taxPrice = taxPrice;
    }

    public double getPriceForNoMatchWords() {
        return priceForNoMatchWords;
    }

    public double getPriceFor75to99MatchWords() {
        return priceFor75to99MatchWords;
    }

    public double getPriceFor100MatchWords() {
        return priceFor100MatchWords;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public int getNumberOfNoMatchWords() {
        return numberOfNoMatchWords;
    }

    public int getNumberOf75to99PercentMatchWords() {
        return numberOf75to99PercentMatchWords;
    }

    public void setNumberOf75to99PercentMatchWords(int numberOf75to99PercentMatchWords) {
        this.numberOf75to99PercentMatchWords = numberOf75to99PercentMatchWords;
    }

    public int getNumberOf100PercentMatchWords() {
        return numberOf100PercentMatchWords;
    }

    public void setNumberOf100PercentMatchWords(int numberOf100PercentMatchWords) {
        this.numberOf100PercentMatchWords = numberOf100PercentMatchWords;
    }

    public void setNumberOfNoMatchWords(int numberOfNoMatchWords) {
        this.numberOfNoMatchWords = numberOfNoMatchWords;
    }

    public int getSignsNumber() {
        return signsNumber;
    }

    public void setSignsNumber(int signsNumber) {
        this.signsNumber = signsNumber;
    }

    private void convertVatPayer() {

        if (vatPayer.equals("yesvat"))
            isVatPayer = true;
        if (vatPayer.equals("novat"))
            isVatPayer = false;
    }


    public double calculate() {
        convertVatPayer();

        switch (translationType) {
            case "plen":
                calculator = new CatToolsCalculator(isVatPayer,ONE_WORD_PRICE_PL_EN_NO_TAX_WITH_CAT,numberOfNoMatchWords,numberOf75to99PercentMatchWords,numberOf100PercentMatchWords);
                break;
            case "enpl":
                calculator = new CatToolsCalculator(isVatPayer,ONE_WORD_PRICE_EN_PL_NO_TAX_WITH_CAT,numberOfNoMatchWords,numberOf75to99PercentMatchWords,numberOf100PercentMatchWords);
                break;
        }
        return calculator.prepareRoundedPrice();

    }
}
