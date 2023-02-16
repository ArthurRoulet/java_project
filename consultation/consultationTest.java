package consultation;

import java.util.Date;

public class consultationTest {

    public static void main(String[] args) {
        Date date = new Date(2001, 10, 4);
        consultation test1 = new consultation(date, 10, 30, 30);

        Date date2 = new Date(2001, 10, 4);
        consultation test2 = new consultation(date, 10, 40, 30);
    }
}