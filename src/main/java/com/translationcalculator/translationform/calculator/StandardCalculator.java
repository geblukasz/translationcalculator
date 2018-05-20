package com.translationcalculator.translationform.calculator;


import java.text.DecimalFormat;

import static com.translationcalculator.translationform.Utils.Variables.*;

public class StandardCalculator extends MainCalculator implements Calculator {

    private boolean isTaxPayer;
    private int signsNumberWithSpaces;
    private int pageVolume;
    private double stake;
    private double price;

    public StandardCalculator(boolean isTaxPayer, int signsNumberWithSpaces, int pageVolume, double stake) {
        super(false, isTaxPayer);
        this.isTaxPayer = isTaxPayer;
        this.signsNumberWithSpaces = signsNumberWithSpaces;
        this.pageVolume = pageVolume;
        this.stake = stake;
    }


    public double calculatePrice() {

        if (isTaxPayer) {
            double netPrice = calculatePagesNumber() * stake;
            double taxPrice = netPrice * 0.23;
            return netPrice + taxPrice;
        } else {
            return calculatePagesNumber() * stake;
        }


    }

    @Override
    public String roundPrice() {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format(calculatePrice());

    }


    @Override
    public double prepareRoundedPrice() {
        Double d = new Double(roundPrice().replace("\"",""));
        return d;
    }

    private double calculatePagesNumber() {
        return (double) signsNumberWithSpaces / pageVolume;
    }


}
