package com.translationcalculator.translationform.model.calculator;


import com.translationcalculator.translationform.utils.Variables;

import java.text.DecimalFormat;

import static com.translationcalculator.translationform.utils.Variables.*;

public class CatToolsCalculator extends MainCalculator implements Calculator {

    private boolean isTaxPayer;
    private double oneWordPrice;
    private int numberOfNoMatchWords;
    private int numberOf75to99PercentMatchWords;
    private int numberOf100PercentMatchWords;
    private CatToolsWebCalculator catToolsWebCalculator;

    double priceForNoMatchWords;
    double priceFor75to99MatchWords;
    double priceFor100MatchWords;
    double totalPrice;
    double taxPrice = totalPrice * Variables.TAX;

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

    public CatToolsCalculator(boolean isTaxPayer, double oneWordPrice, int numberOfNoMatchWords, int numberOf75to99PercentMatchWords, int numberOf100PercentMatchWords) {
        super(false, isTaxPayer);
        this.isTaxPayer = isTaxPayer;
        this.oneWordPrice = oneWordPrice;
        this.numberOfNoMatchWords = numberOfNoMatchWords;
        this.numberOf75to99PercentMatchWords = numberOf75to99PercentMatchWords;
        this.numberOf100PercentMatchWords = numberOf100PercentMatchWords;
    }


    @Override
    public double prepareRoundedPrice() {
        Double d = new Double(roundPrice().replace("\"",""));
        return d;
    }

    @Override
    public String roundPrice() {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format(calculatePrice());

    }

    @Override
    public double calculatePrice() {
        priceForNoMatchWords = calculatePriceDependingOnMatchWords(numberOfNoMatchWords, STAKE_FOR_NO_MATCH_WORDS);
        priceFor75to99MatchWords = calculatePriceDependingOnMatchWords(numberOf75to99PercentMatchWords, STAKE_FOR_75_99_PERCENT_MATCH_WORDS);
        priceFor100MatchWords = calculatePriceDependingOnMatchWords(numberOf100PercentMatchWords, STAKE_FOR_100_PERCENT_MATCH_WORDS);
        totalPrice = priceForNoMatchWords + priceFor75to99MatchWords + priceFor100MatchWords;
        taxPrice = totalPrice * Variables.TAX;
        return isTaxPayer ? totalPrice + (totalPrice * Variables.TAX) : totalPrice;
    }

    private double calculatePriceDependingOnMatchWords(int numberOfWords, double stake) {
        return oneWordPrice * (double) numberOfWords * stake;
    }
}
