package consultation;

import java.util.*;
import java.io.*;

public class consultation {
    private Date date;
    private int hour;
    private int minutes;
    private int duration;

    Scanner scan = new Scanner(System.in);

    ArrayList<Date> dateList = new ArrayList<Date>();
    ArrayList<Integer> hourList = new ArrayList<Integer>();
    ArrayList<Integer> minutesList = new ArrayList<Integer>();
    ArrayList<Integer> durationList = new ArrayList<Integer>();
    ArrayList<Integer> endHourList = new ArrayList<Integer>();
    ArrayList<Integer> endMinutesList = new ArrayList<Integer>();

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
    consultation(Date date, int hour, int minutes, int duration) {
        String msg = verification(date, hour, minutes, duration);
        if (msg == "available") {
            this.date = date;
            this.hour = hour;
            this.minutes = minutes;
            this.duration = duration;
            CompletedList(this.date, this.hour, this.minutes, this.duration);
            System.out.println("consultation confirmed");
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

    // setDuration
    public void setDuration(int duration) {
        this.duration = duration;
    } // end setDuration() method

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

    // getDuration
    public int getDuration() {
        return this.duration;
    } // end getDuration() method

    // list
    public void CompletedList(Date date, int hour, int minutes, int duration) {
        int inter_minutes = 0;
        int inter_hour = 0;

        dateList.add(date);
        hourList.add(hour);
        minutesList.add(minutes);
        durationList.add(duration);

        inter_minutes = minutes + duration;
        while (inter_minutes > 59) {
            inter_minutes = inter_minutes - 60;
            inter_hour += 1;
        }
        inter_hour += hour;

        endHourList.add(inter_hour);
        endMinutesList.add(inter_minutes);
    }

    // verification if the slot is available
    public String verification(Date date, int hour, int minutes, int duration) {
        int inter_hour = 0;
        int inter_minute = 0;
        int inter_duration = 0;
        int end_consultation_hour = 0;
        int end_consultation_minutes = 0;

        String msg = ""; // for the return

        for (int i = 0; i < dateList.size(); i++) {
            if (dateList.get(i) == date) {
                if (endHourList.get(i) == hour) {
                    if (endMinutesList.get(i) <= minutes) {
                        if ((hourList.get(i + 1) == hour) && (minutesList.get(i + 1) > minutes)) {
                            end_consultation_minutes = minutes + duration;
                            end_consultation_hour = hour;

                            while (end_consultation_minutes > 59) {
                                end_consultation_hour += 1;
                                end_consultation_minutes = end_consultation_minutes - 60;
                            }
                            if (end_consultation_hour > hourList.get(i + 1)) {
                                msg = "not available";
                                break;
                            } else if (end_consultation_minutes > minutesList.get(i + 1)) {
                                msg = "not available";
                                break;
                            }
                        } else if (hourList.get(i + 1) > hour) {
                            end_consultation_minutes = minutes + duration;
                            end_consultation_hour = hour;

                            while (end_consultation_minutes > 59) {
                                end_consultation_hour += 1;
                                end_consultation_minutes = end_consultation_minutes - 60;
                            }
                            if (end_consultation_hour > hourList.get(i + 1)) {
                                msg = "not available";
                                break;
                            } else if (end_consultation_minutes > minutesList.get(i + 1)) {
                                msg = "not available";
                                break;
                            }
                        }
                    }
                } else if ((hourList.get(i + 1) == hour) || (hourList.get(i + 1) == hour + 1)) {
                    if (minutesList.get(i + 1) >= minutes) {
                        end_consultation_minutes = minutes + duration;
                        end_consultation_hour = hour;

                        while (end_consultation_minutes > 59) {
                            end_consultation_hour += 1;
                            end_consultation_minutes = end_consultation_minutes - 60;
                        }
                        if (end_consultation_hour > hourList.get(i + 1)) {
                            msg = "not available";
                            break;
                        } else if (end_consultation_minutes > minutesList.get(i + 1)) {
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

        return msg;
    }
}