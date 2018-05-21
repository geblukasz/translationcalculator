package com.translationcalculator.translationform.model;

import com.translationcalculator.translationform.calculator.Calculator;
import com.translationcalculator.translationform.calculator.StandardCalculator;
import lombok.Setter;

import static com.translationcalculator.translationform.Utils.Variables.*;
import lombok.*;

public class FreelancerCalculator {

    @Setter
    private String translationType;
    private int signsNumber;
    private Calculator calculator;
    @Setter
    private String vatPayer;
    private boolean isVatPayer;

    public int getSignsNumber() {
        return signsNumber;
    }

    public void setSignsNumber(int signsNumber) {
        this.signsNumber = signsNumber;
    }

    private void convertVatPayer(){

        if (vatPayer.equals("yesvat"))
            isVatPayer = true;
        if (vatPayer.equals("novat"))
            isVatPayer = false;
    }

    public double calculate(){
        convertVatPayer();

        switch (translationType){
            case "plen":
                calculator = new StandardCalculator(isVatPayer, signsNumber, PAGE_VOLUME_PL_EN_NO_TAX_NO_CAT, STAKE_PL_EN_NO_TAX_NO_CAT);
                break;
            case  "enpl":
                calculator = new StandardCalculator(isVatPayer, signsNumber, PAGE_VOLUME_EN_PL_NO_TAX_NO_CAT, STAKE_EN_PL_NO_TAX_NO_CAT);
                break;
        }
        return calculator.prepareRoundedPrice();

    }
}