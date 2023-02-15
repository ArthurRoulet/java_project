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

    // constructor
    // default constructor
    consultation() {
        System.out.println("Choose a date for a consultation");
        this.date = scan.nextLine();
        System.out.println("Choose a hour for a consultation");
        this.hour = scan.nextInt();
        System.out.println("Choose a minute for a consultation");
        this.minutes = scan.nextInt();
        System.out.println("Choose a duration for a consultation");
        this.duration = scan.nextInt();

        String msg = verification(date, hour, minutes, duration);
        if (msg == "available") {
            this.date = date;
            this.hour = hour;
            this.minutes = minutes;
            this.duration = duration;
            CompletedList(this.date, this.hour, this.minutes, this.duration);
        } else {
            System.out.println("the consultation is not available");
            System.out.println("choose a other consultation");
        }
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
        dateList.add(date);
        hourList.add(hour);
        minutesList.add(minutes);
        durationList.add(duration);
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
                if (hourList.get(i) == hour) {
                    if (minutesList.get(i) == minutes) {
                        msg = "not available";
                        break;
                    }
                } else {
                    // data recovery
                    inter_hour = hourList.get(i);
                    inter_minute = minutesList.get(i);
                    inter_duration = durationList.get(i);

                    // end of the consultation
                    end_consultation_minutes = inter_minute + inter_duration;
                    if (end_consultation_minutes > 59) {
                        while (end_consultation_minutes > 59) {
                            end_consultation_hour = end_consultation_hour + 1;
                            end_consultation_minutes = end_consultation_minutes - 60;
                        }
                    }

                    if ((hour > inter_hour - 1) && (minutes > inter_minute - 1)) {
                        if ((hour < end_consultation_hour + 1) && (minutes < end_consultation_minutes + 1)) {
                            msg = "not available";
                            break;
                        }
                    } else {
                        // verification compared with the next consultation
                        // data recovery
                        end_consultation_minutes = 0;
                        end_consultation_hour = 0;
                        end_consultation_minutes = minutes + duration;
                        end_consultation_hour = hour;

                        while (end_consultation_minutes < 59) {
                            end_consultation_minutes = end_consultation_minutes - 60;
                            end_consultation_hour = end_consultation_hour + 1;
                        }

                        // data recovery
                        inter_hour = 0;
                        inter_minute = 0;
                        inter_duration = 0;
                        inter_hour = hourList.get(i + 1);
                        inter_minute = minutesList.get(i + 1);
                        inter_duration = durationList.get(i + 1);

                        if ((end_consultation_hour <= inter_hour)) {
                            if (end_consultation_minutes <= inter_minute) {
                                msg = "available";
                                CompletedList(date, hour, minutes, duration);
                                break;
                            } else {
                                msg = "not available";
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (msg == "available") {
        } else {
            msg = "not available";
        }
        return msg;
    }
}