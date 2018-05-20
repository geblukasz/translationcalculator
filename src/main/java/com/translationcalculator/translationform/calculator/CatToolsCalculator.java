package com.translationcalculator.translationform.calculator;


import com.translationcalculator.translationform.Utils.Variables;

import java.text.DecimalFormat;

import static com.translationcalculator.translationform.Utils.Variables.*;

public class CatToolsCalculator extends MainCalculator implements Calculator {

    private boolean isTaxPayer;
    private double oneWordPrice;
    private int numberOfNoMatchWords;
    private int numberOf75to99PercentMatchWords;
    private int numberOf100PercentMatchWords;

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
        double priceForNoMatchWords = calculatePriceDependingOnMatchWords(numberOfNoMatchWords, STAKE_FOR_NO_MATCH_WORDS);
        double priceFor75to99MatchWords = calculatePriceDependingOnMatchWords(numberOf75to99PercentMatchWords, STAKE_FOR_75_99_PERCENT_MATCH_WORDS);
        double priceFor100MatchWords = calculatePriceDependingOnMatchWords(numberOf100PercentMatchWords, STAKE_FOR_100_PERCENT_MATCH_WORDS);
        double totalPrice = priceForNoMatchWords + priceFor75to99MatchWords + priceFor100MatchWords;
        return isTaxPayer ? totalPrice + (totalPrice * Variables.TAX) : totalPrice;
    }

    private double calculatePriceDependingOnMatchWords(int numberOfWords, double stake) {
        return oneWordPrice * (double) numberOfWords * stake;
    }
}
