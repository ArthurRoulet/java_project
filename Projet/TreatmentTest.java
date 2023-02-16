package Projet;

import java.util.*;
import java.text.*;

public class TreatmentTest {
    public static void main(String[] args) {

        Date startDate = new Date();
        Date endDate = new Date();

        // TODO NEW TREATMENT
        // create two objects (instance) of the class Treatment
        Treatment myTreatment = new Treatment(null, null, startDate, endDate, null, null, null, 0, null, null);

        Scanner console = new Scanner(System.in);

        // Prompt user to enter the treatment name
        System.out.print("Enter treatment name: ");
        String name = console.nextLine();
        myTreatment.setName(name);

        // Prompt user to enter the treatment description
        System.out.print("Enter treatment description: ");
        String description = console.nextLine();
        myTreatment.setDescription(description);

        // !Prompt user to enter the start date of the treatment
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        System.out.print("Enter the start date (MM/dd/yyyy): ");
        String startDateString = console.nextLine();

        try {
            startDate = dateFormat.parse(startDateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format, please try again.");
        }

        // !Prompt user to enter the end date of the treatment
        System.out.print("Enter the end date (MM/dd/yyyy): ");
        String endDateString = console.nextLine();

        try {
            endDate = dateFormat.parse(endDateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format, please try again.");
        }

        // Prompt user to enter the frequency of the treatment
        System.out.print("Enter frequency of the treatment: ");
        String frequency = console.nextLine();
        myTreatment.setFrequency(frequency);

        // Prompt user to enter the way to take the treatment
        System.out.print("Enter way to take the treatment: ");
        String wayToTake = console.nextLine();
        myTreatment.setWayToTake(wayToTake);

        // Prompt user to enter the dosage of the treatment
        System.out.print("Enter dosage of the treatment: ");
        String dosage = console.nextLine();
        myTreatment.setDosage(dosage);

        // Prompt user to enter the cost of the treatment
        System.out.print("Enter cost of the treatment (just the number): ");
        int cost = console.nextInt();
        myTreatment.setCost(cost);

        console.nextLine(); // consume the remaining newline character

        // Prompt user to enter the associated doctor of the treatment
        System.out.print("Enter associated doctor of the treatment: ");
        String associatedDoctor = console.nextLine();
        myTreatment.setAssociatedDoctor(associatedDoctor);

        // Prompt user to enter the associated patient of the treatment
        System.out.print("Enter associated patient of the treatment: ");
        String associatedPatient = console.nextLine();
        myTreatment.setAssociatedPatient(associatedPatient);

        // print the result
        System.out.println(myTreatment);

        // TODO MODIFY A TREATMENT

        console.close();
    }
}
