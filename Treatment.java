package Projet;

import java.util.*;

public class Treatment {
    private static int nextId = 1;

    // Data members
    private int treatmentId;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String frequency;
    private String wayToTake;
    private String dosage;
    private int cost;
    private String associatedDoctor;
    private String associatedPatient;

    // Constructors
    public Treatment(String name, String description, Date startDate, Date endDate, String frequency, String wayToTake,
            String dosage, int cost, String associatedDoctor, String associatedPatient) {
        this.treatmentId = nextId++;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
        this.wayToTake = wayToTake;
        this.dosage = dosage;
        this.cost = cost;
        this.associatedDoctor = associatedDoctor;
        this.associatedPatient = associatedPatient;
    }


    private static List<Treatment> treatments = new ArrayList<>();

    //! SETTERS

    //set id
    public void setTreatmentId(int theTreatmentId) {
        this.treatmentId = theTreatmentId;
    }

    //set the name
    public void setName(String theName) {
        this.name = theName;
    }

    //set the description
    public void setDescription(String theDescription) {
        this.description = theDescription;
    }

    //set the start date and the end date
    public void setStartDate(Date theStartDate) {
        this.startDate = theStartDate;
    }
    public void setEndDate(Date theEndDate) {
        this.endDate = theEndDate;
    }

    //set the frequency
    public void setFrequency(String theFrequency) {
        this.frequency = theFrequency;
    }

    //set the way to take
    public void setWayToTake(String theWayToTake) {
        this.wayToTake = theWayToTake;
    }

    //set the dosage
    public void setDosage(String theDosage) {
        this.dosage = theDosage;
    }

    //set the cost
    public void setCost(int theCost) {
        this.cost = theCost;
    }

    //set the associated doctor
    public void setAssociatedDoctor(String theAssociatedDoctor) {
        this.associatedDoctor = theAssociatedDoctor;
    }

    //set the associated patient
    public void setAssociatedPatient(String theAssociatedPatient) {
        this.associatedPatient = theAssociatedPatient;
    }



    //! GETTERS

    public int getTreatmentId() {
        return this.treatmentId;
    }

    //return the name of the treatment (getters)
    public String getName() {
        return this.name;
    }

    //return description
    public String getDescription() {
        return this.description;
    }

    //return the startDate and the endDate of the treatment
    public Date getStartDate() {
        return this.startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }

    //return the frequency 
    public String getFrequency() {
        return this.frequency;
    }

    //return the way to take the treatment
    public String getWayToTake() {
        return this.wayToTake;
    }

    //return the dosage
    public String getDosage() {
        return this.dosage;
    }

    //return the cost of the treatment
    public int getCost() {
        return this.cost;
    }

    //return the doctor associated with the treatment
    public String getAssociatedDoctor() {
        return this.associatedDoctor;
    }

    //return the patient who take the treatment
    public String getAssociatedPatient() {
        return this.associatedPatient;
    }



    //! The methods


    // Adds a new treatment to the system
    public static void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    // Modifies an existing treatment's information
    public static void modifyTreatment(int treatmentId, Treatment newTreatment) {
        for (int i = 0; i < treatments.size(); i++) {
            if (treatments.get(i).getTreatmentId() == treatmentId) {
                // Update the fields of the existing treatment with the new values
                treatments.get(i).setName(newTreatment.getName());
                treatments.get(i).setDescription(newTreatment.getDescription());
                treatments.get(i).setStartDate(newTreatment.getStartDate());
                treatments.get(i).setEndDate(newTreatment.getEndDate());
                treatments.get(i).setFrequency(newTreatment.getFrequency());
                treatments.get(i).setWayToTake(newTreatment.getWayToTake());
                treatments.get(i).setDosage(newTreatment.getDosage());
                treatments.get(i).setCost(newTreatment.getCost());
                treatments.get(i).setAssociatedDoctor(newTreatment.getAssociatedDoctor());
                treatments.get(i).setAssociatedPatient(newTreatment.getAssociatedPatient());
                
                break;
            }
        }
    }

    // Removes a treatment from the system
    public static void removeTreatment(int treatmentId) {
        for (int i = 0; i < treatments.size(); i++) {
            if (treatments.get(i).getTreatmentId() == treatmentId) {
                treatments.remove(i);
                break;
            }
        }
    }


    // Displays treatment in the system
    @Override
    public String toString() {
        return String.format("The treatment %s, %s, by %s costing %s, is administered from %s to %s to the patient %s by the doctor %s.%nIt will be taken with a frequency of %s and dosage of %s%n", 
        getName(), getDescription(), getWayToTake(), getCost(), getStartDate(), getEndDate(), 
        getAssociatedPatient(), getAssociatedDoctor(), getFrequency(), getDosage());
    }
}