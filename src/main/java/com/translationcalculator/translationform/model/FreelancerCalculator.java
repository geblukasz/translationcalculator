package com.translationcalculator.translationform.model;

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

    public int calculate(){
        return signsNumber*2;
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