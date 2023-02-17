package person;

import java.util.*;
import java.io.*;

public class person {
    // data members
    private String firstName;
    private String lastName;
    private Date DateOfBirth;
    private int phoneNumber;
    private String adress;

    // default constructor
    person() {
    } // end default constructor

    // constructor with parameters
    person(String FName, String LName, Date DOB, int PNumber, String adress) {
        this.firstName = FName;
        this.lastName = LName;
        this.DateOfBirth = DOB;
        this.phoneNumber = PNumber;
        this.adress = adress;
    } // end of constructor

    // seters
    // set First Name
    public void setFirstName(String FName) {
        this.firstName = FName;
    } // end setFirstName method

    // set Last Name
    public void setLastName(String LName) {
        this.lastName = LName;
    } // end setLastName method

    // set Date of birth
    public void setDateOfBirth(Date DOB) {
        this.DateOfBirth = DOB;
    } // end setDateOfBirth method

    // set phone number
    public void setPhoneNumber(int PNumber) {
        this.phoneNumber = PNumber;
    } // end setPhoneNumber method

    // set adress
    public void setAdress(String adress) {
        this.adress = adress;
    } // end setAdress method

    // getters
    // get First Name
    public String getFirstName() {
        return this.firstName;
    } // end getFirstName method

    // get Last Name
    public String getLastName() {
        return this.lastName;
    } // end getLastName method

    // get Date of birth
    public Date getDateOfBirth() {
        return this.DateOfBirth;
    } // end getDateOfBirth method

    // get phone number
    public int getPhoneNumber() {
        return this.phoneNumber;
    } // end getPhoneNumber method

    // get adress
    public String getAdress() {
        return this.adress;
    } // end getAdress method
}
