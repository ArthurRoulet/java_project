package consultation;

import java.util.*;
import java.io.*;

public class consultationTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Date date = new Date(2001, 10, 4);
        consultation test1 = new consultation(date, 10, 30);

        Date date2 = new Date(2022, 10, 4);
        consultation test2 = new consultation(date2, 10, 40);

        Date date3 = new Date(2022, 10, 4);
        consultation test3 = new consultation(date3, 11, 0);
    }
}