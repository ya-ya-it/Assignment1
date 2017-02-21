/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dasha
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String zip = "k7k4o5";

        Pattern pattern = Pattern.compile("^[(a-z)][(\\d)][(a-z)][(\\d)][(a-z)][(\\d)]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(zip);

        if (zip.length() == 6) {
            if (matcher.find()) {
                System.out.println("Valid");
            }
        } else {
            System.out.println("Invalid");
        }
    }
}
