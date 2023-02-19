package person;

import java.util.*;
import java.io.*;

import Projet.Treatment;

public class doctor extends person {
    // data members
    private String specialty;
    private Date dateEmployed;

    // default constructor
    doctor() {
    } // end default construcor

    // constructor with parameters
    doctor(String FName, String LName, Date DOB, int PNumber, String adress, String spe, Date DEmployed) {
        super(FName, LName, DOB, PNumber, adress);
        this.specialty = spe;
        this.dateEmployed = DEmployed;
    } // end constructor

    // setters
    // set specialty
    public void setSpecialty(String spe) {
        this.specialty = spe;
    } // end setSpecialty method

    // set date employed
    public void setDateEmployed(Date DEmployed) {
        this.dateEmployed = DEmployed;
    }

    // getters
    // get specialty
    public String getSpecialty() {
        return this.specialty;
    } // end getSpecialty method

    // get date employed
    public Date getDateEmployed() {
        return this.dateEmployed;
    } // end getDateEmployed

    // vision of the next consultation
    public void NextConsultation() throws FileNotFoundException {
        int day, month, year;
        int hour, min;
        int endHour, endMin;

        Scanner inFile; // instance of the FileReader class
        inFile = new Scanner(
                new FileReader("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt"));

        day = inFile.nextInt();
        month = inFile.nextInt();
        year = inFile.nextInt();

        hour = inFile.nextInt();
        min = inFile.nextInt();
        endHour = inFile.nextInt();
        endMin = inFile.nextInt();

        System.out.println("Your next consultation is the " + day + "/" + month + "/" + year
                + " and begin at " + hour + ":" + min + " and finish at " + endHour + ":" + endMin);

        // close the inFile and outFile objects
        inFile.close();
    } // end NextConsultation method

    // creation of treatment
    public void creationTreatment() {
        String name;
        String description;
        int day, month, year;
        Date startDate;
        Date endDate;
        String frequency;
        String wayToTake;
        String dosage;
        int cost;
        String associatedDoctor;
        String associatedPatient;

        Scanner demand = new Scanner(System.in);

        System.out.println("Name of the treatment : ");
        name = demand.next();

        System.out.println("Description of the treatment : ");
        description = demand.next();

        System.out.println("What is a date for start the treatment (day, month, year separeted by space)");
        day = demand.nextInt();
        month = demand.nextInt();
        year = demand.nextInt();
        startDate = new Date(year, month, day);
        day = month = year = 0;

        System.out.println("What is a date for stop the treatment (day, month, year separeted by space)");
        day = demand.nextInt();
        month = demand.nextInt();
        year = demand.nextInt();
        endDate = new Date(year, month, day);

        System.out.println("Frequency of the treatment : ");
        frequency = demand.next();

        System.out.println("Way to take :");
        wayToTake = demand.next();

        System.out.println("Dosage of the treatment : ");
        dosage = demand.next();

        System.out.println("cost of the treatment :");
        cost = demand.nextInt();

        System.out.println("Doctor :");
        associatedDoctor = demand.next();

        System.out.println("patient : ");
        associatedPatient = demand.next();

        new Treatment(name, description, startDate, endDate, frequency, wayToTake, dosage, cost, associatedDoctor,
                associatedPatient);
    } // creationTreatment method

    // see information on the patient
    public void informationPatient() {
        // String informationPatient = patient.toString();
        // System.out.println(informationPatient);
    }

    // override String method
    @Override
    public String toString() {
        return "name : " + super.getFirstName() + " " + super.getLastName() +
                ", specialty : " + this.getSpecialty() +
                ", phone number : " + super.getPhoneNumber() + ", adress : " + super.getAdress()
                + ", date employed :" + this.getDateEmployed();
    }
}
