package consultation;

import java.util.*;
import java.io.*;

public class consultationTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner inFile; // instance of the FileReader class
        PrintWriter outFile; // instance of PrintWriter class
        inFile = new Scanner(
                new FileReader("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt"));
        outFile = new PrintWriter("C:\\Users\\arthu\\OneDrive\\Bureau\\java_project\\consultation\\consultation.txt");

        Date date = new Date(2001, 10, 4);
        consultation test1 = new consultation(date, 10, 30);

        Date date2 = new Date(2022, 10, 4);
        consultation test2 = new consultation(date, 10, 40);

        // close the inFile and outFile objects
        inFile.close();
        outFile.close();
    }
}