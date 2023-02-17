package consultation;

import java.util.*;

import javax.swing.JPopupMenu.Separator;

import java.io.*;

public class consultation {
    private Date date;
    private int hour;
    private int minutes;

    Scanner scan = new Scanner(System.in);

    // constructor
    // default constructor
    consultation() {
    } // end of default constructor

    // constructor with parameters
    consultation(Date date, int hour, int minutes) throws FileNotFoundException, IOException {
        String msg = verification(date, hour, minutes);
        if (msg == "available") {
            this.date = date;
            this.hour = hour;
            this.minutes = minutes;
            CompletedList(this.date, this.hour, this.minutes);
            System.out.println("consultation confirmed at " + this.hour + ":" + this.minutes + " the " +
                    this.date.getDay() + "/" + this.date.getMonth() + "/" + this.date.getYear());
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
        inFile = new Scanner(
                new FileReader("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt"));
        outFile = new PrintWriter("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt");

        inter_minutes = minutes + 30;
        while (inter_minutes > 59) {
            inter_minutes = inter_minutes - 60;
            inter_hour += 1;
        }
        inter_hour += hour;

        outFile.write(
                day + " " + month + " " + year + " " + hour + " " + minutes + " " + inter_hour + " " + inter_minutes
                        + "\n");
        outFile.println();

        // close the inFile and outFile objects
        inFile.close();
        outFile.close();
    }

    // verification if the slot is available
    public String verification(Date date, int hour, int minutes) throws FileNotFoundException, IOException {
        int inter_hour = 0;
        int inter_minute = 0;
        int end_consultation_hour = 0;
        int end_consultation_minutes = 0;
        int day;
        int month;
        int year;

        Scanner inFile; // instance of the FileReader class
        PrintWriter outFile; // instance of PrintWriter class

        String msg = ""; // for the return

        ArrayList<Date> Date = new ArrayList<Date>(); // date of consultation
        // hour of consultation
        ArrayList<Integer> Hour = new ArrayList<Integer>();
        ArrayList<Integer> Min = new ArrayList<Integer>();
        // end of consultation
        ArrayList<Integer> endHour = new ArrayList<Integer>();
        ArrayList<Integer> endMin = new ArrayList<Integer>();

        int nbr_lign = control_lign();

        System.out.println(nbr_lign);

        inFile = new Scanner(
                new FileReader("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt"));
        outFile = new PrintWriter("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt");

        // recuperate data of consultation.txt
        for (int z = 0; z < nbr_lign; z++) {
            day = inFile.nextInt();
            month = inFile.nextInt();
            year = inFile.nextInt();

            Hour.add(inFile.nextInt());
            Min.add(inFile.nextInt());
            endHour.add(inFile.nextInt());
            endMin.add(inFile.nextInt());
        }

        for (int i = 0; i < nbr_lign; i++) {
            // if is the date of the consultation demand
            if (Date.get(i) == date) {
                // if is the consultation end during the same period of the donsultation demand
                if (endHour.get(i) == hour) {
                    if (endMin.get(i) <= minutes) {
                        // consultation of the consultation who come after
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
                    // else if the end of the consultation if after the begin of consultation demand
                } else if ((Hour.get(i) == hour) && (endHour.get(i) > hour)) {
                    msg = "not available";
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

    public int control_lign() throws IOException {
        File i = new File("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt");

        return (int) (i.length());
    }
}
