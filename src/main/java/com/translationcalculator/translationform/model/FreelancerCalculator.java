package com.translationcalculator.translationform.model;

import com.translationcalculator.translationform.calculator.Calculator;
import com.translationcalculator.translationform.calculator.StandardCalculator;

import static com.translationcalculator.translationform.Utils.Variables.PAGE_VOLUME_PL_EN_NO_TAX_NO_CAT;
import static com.translationcalculator.translationform.Utils.Variables.STAKE_PL_EN_NO_TAX_NO_CAT;

public class FreelancerCalculator {
	 
    private int signsNumber;
    /*private String firstname;
    private String lastname;
     */
 
    public int getSignsNumber() {
        return signsNumber;
    }
 
    public void setSignsNumber(int signsNumber) {
        this.signsNumber = signsNumber;
    }

    public double calculate(){
        Calculator calculator = new StandardCalculator(false, signsNumber, PAGE_VOLUME_PL_EN_NO_TAX_NO_CAT, STAKE_PL_EN_NO_TAX_NO_CAT);
//        System.out.println("Cena bez vat i bez cat PL-EN: " + calculator.prepareRoundedPrice());
        return calculator.prepareRoundedPrice();
    }
 
    /*public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
 */
}