package consultation;

import java.util.*;
import java.io.*;

public class consultation {
    private Date date;
    private int hour;
    private int minutes;

    Scanner scan = new Scanner(System.in);

    // constructor
    // default constructor
    consultation() {
        /*
         * System.out.println("Choose a date for a consultation");
         * this.date = scan.nextLine();
         * System.out.println("Choose a hour for a consultation");
         * this.hour = scan.nextInt();
         * System.out.println("Choose a minute for a consultation");
         * this.minutes = scan.nextInt();
         * System.out.println("Choose a duration for a consultation");
         * this.duration = scan.nextInt();
         * 
         * String msg = verification(date, hour, minutes, duration);
         * if (msg == "available") {
         * this.date = date;
         * this.hour = hour;
         * this.minutes = minutes;
         * this.duration = duration;
         * CompletedList(this.date, this.hour, this.minutes, this.duration);
         * } else {
         * System.out.println("the consultation is not available");
         * System.out.println("choose a other consultation");
         * }
         */
    } // end of default constructor

    // constructor with parameters
    consultation(Date date, int hour, int minutes) throws FileNotFoundException {
        String msg = verification(date, hour, minutes);
        if (msg == "available") {
            this.date = date;
            this.hour = hour;
            this.minutes = minutes;
            CompletedList(this.date, this.hour, this.minutes);
            System.out.println("consultation confirmed at " + this.hour + ":" + this.minutes + " the " + this.date);
        } else {
            System.out.println("the consultation is not available");
            System.out.println("choose a other consultation");
        }
    } // end of constructor with parameters

    // setters
    // setDate
    public void setDate(Date date) {
        this.date = date;
    } // end setDate() method

    // setHour
    public void setHour(int hour) {
        this.hour = hour;
    } // end setHour() method

    // setMinutes
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    } // end setMinutes() method

    // getters
    // getDate
    public Date getDate() {
        return this.date;
    } // end getDate() method

    // getHour
    public int getHour() {
        return this.hour;
    } // end getHour() method

    // getMinutes
    public int getMinutes() {
        return this.minutes;
    } // end getMinutes() method

    // list
    public void CompletedList(Date date, int hour, int minutes) throws FileNotFoundException {
        int inter_minutes = 0;
        int inter_hour = 0;
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();

        Scanner inFile; // instance of the FileReader class
        PrintWriter outFile; // instance of PrintWriter class
        inFile = new Scanner(new FileReader("C:\\java_project\\consultation\\consultation.txt"));
        outFile = new PrintWriter("C:\\java_project\\consultation\\consultation.txt");

        inter_minutes = minutes + 30;
        while (inter_minutes > 59) {
            inter_minutes = inter_minutes - 60;
            inter_hour += 1;
        }
        inter_hour += hour;

        outFile.println(
                day + " " + month + " " + year + " " + hour + " " + minutes + " " + inter_hour + " " + inter_minutes);

        // close the inFile and outFile objects
        inFile.close();
        outFile.close();
    }

    // verification if the slot is available
    public String verification(Date date, int hour, int minutes) throws FileNotFoundException {
        int inter_hour = 0;
        int inter_minute = 0;
        int end_consultation_hour = 0;
        int end_consultation_minutes = 0;

        Scanner inFile; // instance of the FileReader class
        PrintWriter outFile; // instance of PrintWriter class
        inFile = new Scanner(new FileReader("C:\\java_project\\consultation\\consultation.txt"));
        outFile = new PrintWriter("C:\\java_project\\consultation\\consultation.txt");

        String msg = ""; // for the return

        ArrayList<Date> Date = new ArrayList<Date>(); // date of consultation
        // hour of consultation
        ArrayList<Integer> Hour = new ArrayList<Integer>();
        ArrayList<Integer> Min = new ArrayList<Integer>();
        // end of consultation
        ArrayList<Integer> endHour = new ArrayList<Integer>();
        ArrayList<Integer> endMin = new ArrayList<Integer>();

        // recuperate data of consultation.txt
        for (int z = 0; z < 200; z++) {
            int day = inFile.nextInt();
            int month = inFile.nextInt();
            int year = inFile.nextInt();
            Date.add(new Date(year, month, day));

            Hour.add(inFile.nextInt());
            Min.add(inFile.nextInt());
            endHour.add(inFile.nextInt());
            endMin.add(inFile.nextInt());
        }

        for (int i = 0; i < Date.size(); i++) {
            if (Date.get(i) == date) {
                if (endHour.get(i) == hour) {
                    if (endMin.get(i) <= minutes) {
                        if ((Hour.get(i + 1) == hour) && (Min.get(i + 1) > minutes)) {
                            end_consultation_minutes = minutes + 30;
                            end_consultation_hour = hour;

                            while (end_consultation_minutes > 59) {
                                end_consultation_hour += 1;
                                end_consultation_minutes = end_consultation_minutes - 60;
                            }
                            if (end_consultation_hour > Hour.get(i + 1)) {
                                msg = "not available";
                                break;
                            } else if (end_consultation_minutes > Min.get(i + 1)) {
                                msg = "not available";
                                break;
                            }
                        } else if (Hour.get(i + 1) > hour) {
                            end_consultation_minutes = minutes + 30;
                            end_consultation_hour = hour;

                            while (end_consultation_minutes > 59) {
                                end_consultation_hour += 1;
                                end_consultation_minutes = end_consultation_minutes - 60;
                            }
                            if (end_consultation_hour > Hour.get(i + 1)) {
                                msg = "not available";
                                break;
                            } else if (end_consultation_minutes > Min.get(i + 1)) {
                                msg = "not available";
                                break;
                            }
                        }
                    }
                } else if ((Hour.get(i + 1) == hour) || (Hour.get(i + 1) == hour + 1)) {
                    if (Min.get(i + 1) >= minutes) {
                        end_consultation_minutes = minutes + 30;
                        end_consultation_hour = hour;

                        while (end_consultation_minutes > 59) {
                            end_consultation_hour += 1;
                            end_consultation_minutes = end_consultation_minutes - 60;
                        }
                        if (end_consultation_hour > Hour.get(i + 1)) {
                            msg = "not available";
                            break;
                        } else if (end_consultation_minutes > Min.get(i + 1)) {
                            msg = "not available";
                            break;
                        }
                    }
                }
            }
        }
        if (msg == "") {
            msg = "available";
        }
        // close the inFile and outFile objects
        inFile.close();
        outFile.close();

        return msg;
    }
}