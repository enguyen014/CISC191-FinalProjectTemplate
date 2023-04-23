package edu.sdccd.cisc191.template;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */
public class mod7
{
    public static void main(String[] args) {
    }

    public static String readTestResults(String s) {
        String output = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + s));
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                output += data;
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        return output;
    }


    public static void appendTestResult(String s, String s1) {
        try {
            BufferedWriter writer = new BufferedWriter (new FileWriter("src/main/resources/" + s,true));
            writer.write(s1);
            writer.close();

        } catch (Exception e) {
            return;
        }

    }

    public static String readDateTime(String s) {
        String output = "";
        try {
            URL url = new URL(s);
            Scanner input = new Scanner(url.openStream());

            String dataInput = input.nextLine();

            String search = "\"datetime\":\"";
            int startIndex = Integer.valueOf(dataInput.indexOf(search) + search.length());
            int endIndex = Integer.valueOf(dataInput.indexOf("\"", startIndex));
            output = dataInput.substring(startIndex, endIndex);

            input.close();

        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
        return output;
    }
}