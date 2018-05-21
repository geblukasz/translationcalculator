package com.translationcalculator.translationform.model;

import com.translationcalculator.translationform.calculator.Calculator;
import lombok.Setter;

import java.text.DecimalFormat;

import static com.translationcalculator.translationform.Utils.Variables.*;

public class CatToolsWebCalculator {


    @Setter
    private String translationType;
    private int signsNumber;
    private Calculator calculator;
    @Setter
    private String vatPayerString;
    private boolean isVatPayer;
    private double oneWordPrice;
    private int numberOfNoMatchWords;
    private int numberOf75to99PercentMatchWords;
    private int numberOf100PercentMatchWords;

    double priceForNoMatchWords;
    double priceFor75to99MatchWords;
    double priceFor100MatchWords;
    double totalPrice;
    double netPrice;
    double taxPrice;

    public boolean isVatPayer() {
        return isVatPayer;
    }

    public void setVatPayer(boolean vatPayer) {
        isVatPayer = vatPayer;
    }

    public void setNumberOfNoMatchWords(int numberOfNoMatchWords) {
        this.numberOfNoMatchWords = numberOfNoMatchWords;
    }

    public void setNumberOf75to99PercentMatchWords(int numberOf75to99PercentMatchWords) {
        this.numberOf75to99PercentMatchWords = numberOf75to99PercentMatchWords;
    }

    public void setNumberOf100PercentMatchWords(int numberOf100PercentMatchWords) {
        this.numberOf100PercentMatchWords = numberOf100PercentMatchWords;
    }

    public int getNumberOfNoMatchWords() {
        return numberOfNoMatchWords;
    }

    public int getNumberOf75to99PercentMatchWords() {
        return numberOf75to99PercentMatchWords;
    }

    public int getNumberOf100PercentMatchWords() {
        return numberOf100PercentMatchWords;
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

    public double getNetPrice() {
        return netPrice;
    }

    public CatToolsWebCalculator() {
    }

    public double prepareCalculations() {
        if (vatPayerString.equals("yesvat"))
            this.isVatPayer = true;
        else if (vatPayerString.equals("novat"))
            this.isVatPayer = false;

        if (translationType.equals("plen")) {
            this.oneWordPrice = ONE_WORD_PRICE_PL_EN_NO_TAX_WITH_CAT;
        } else if (translationType.equals("enpl")) {
            this.oneWordPrice = ONE_WORD_PRICE_EN_PL_NO_TAX_WITH_CAT;
        }

        return calculatePrice();
    }

    private double calculatePrice() {

        priceForNoMatchWords = roundPrice(calculatePriceForOnMatchWords());
        priceFor75to99MatchWords = roundPrice(calculatePriceFor75to99MatchWords());
        priceFor100MatchWords = roundPrice(calculatePriceFor100MatchWords());

        if (isVatPayer) {
            netPrice = roundPrice(priceForNoMatchWords + priceFor75to99MatchWords + priceFor100MatchWords);
            taxPrice = roundPrice(calculateTaxPrice());
            totalPrice = roundPrice(netPrice + taxPrice);
            return totalPrice;
        } else {
            return roundPrice(priceForNoMatchWords + priceFor75to99MatchWords + priceFor100MatchWords);
        }
    }

    private double calculateTaxPrice() {
        return netPrice * TAX;
    }

    private double calculateTotalPrice() {
        return priceForNoMatchWords + priceFor75to99MatchWords + priceFor100MatchWords;

    }

    private double calculatePriceForOnMatchWords() {
        return numberOfNoMatchWords * oneWordPrice * STAKE_FOR_NO_MATCH_WORDS;
    }

    private double calculatePriceFor75to99MatchWords() {
        return numberOf75to99PercentMatchWords * oneWordPrice * STAKE_FOR_75_99_PERCENT_MATCH_WORDS;
    }

    private double calculatePriceFor100MatchWords() {
        return numberOf100PercentMatchWords * oneWordPrice * STAKE_FOR_100_PERCENT_MATCH_WORDS;
    }

    private double roundPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        Double priceDouble = new Double(decimalFormat.format(price).replace("\"", ""));
        return priceDouble;

    }
}
