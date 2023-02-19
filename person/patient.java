package person;

import java.util.*;
import java.io.*;

import consultation.consultation;
import Projet.Treatment;

public class patient extends person {
    // data members
    private String employer;
    private String insurranceCo;
    private String sex;
    private ArrayList<String> antecedent = new ArrayList<String>();
    private Consultation consult;

    // default constructor
    patient() {
    } // end default constructor

    // constructor with parameters
    patient(String fName, String lName, Date dOB, int pNumber, String adress, String employer, String iCo, String s) {
        super(fName, lName, dOB, pNumber, adress);
        this.employer = employer;
        this.insurranceCo = iCo;
        this.sex = s;
    } // end constructor

    // setters
    // set employer
    public void setEmployer(String employer) {
        this.employer = employer;
    } // end setEmployer method

    // set InsurranceCo
    public void setInsurranceCo(String iCo) {
        this.insurranceCo = iCo;
    } // end setInssurranceCo method

    // set sex
    public void setSex(String sex) {
        this.sex = sex;
    } // end setSex method

    // set antecedent
    public void setAntecedent(String antecedent) {
        this.antecedent.add(antecedent);
    } // end setAntecedent method

    // getters
    // get employer
    public String getEmployer() {
        return this.employer;
    } // end getEmployer method

    // get InsurranceCo
    public String getInsurranceCo() {
        return this.insurranceCo;
    } // end getInsurranceCo method

    // get sex
    public String getSex() {
        return this.sex;
    } // end getSex method

    // get antecedent
    public ArrayList getAntecedent() {
        return this.antecedent;
    } // end getAntecedent method

    // demand of consultation
    public void demandConsultation() {
        Scanner demand = new Scanner(System.in);
        Date demandDate;
        int day, month, year;
        int hour, min;

        System.out.println("Date for the consultation : (day, month, year separate by space)");
        day = demand.nextInt();
        month = demand.nextInt();
        year = demand.nextInt();
        demandDate = new Date(year, month, day);

        System.out.println("hour for the consultation : (hour and minutes separated by space)");
        hour = demand.nextInt();
        min = demand.nextInt();

        // consult = new consultation(demandDate, hour, min);

    } // end demandConsultation method

    // see the treatment
    public void seeTreatment() {
        // String information = Treatment.toString();
        // System.out.println(information);
    } // end seeTreatment

    // override String method
    @Override
    public String toString() {
        return "name : " + super.getFirstName() + " " + super.getLastName() +
                ", Date of Birth : " + super.getDateOfBirth() + ", sex : " + this.getSex() +
                "phone number : " + super.getPhoneNumber() + ", adress" + super.getAdress() +
                ", employer : " + this.getEmployer() + ", Insurrance company : " + this.getInsurranceCo() +
                ", angtecedent : " + this.getAntecedent();
    }
}
