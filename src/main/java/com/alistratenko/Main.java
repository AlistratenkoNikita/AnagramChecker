package com.alistratenko;

import com.alistratenko.anagram.AnagramCheckerI;
import com.alistratenko.anagram.AnagramChecker;

import java.io.*;

/**
 * @author Nikita
 * @since 29.08.2017
 */
public class Main {
    public static void main(String[] args) {
        AnagramCheckerI checker = new AnagramChecker();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1;
        String line2;
        try {
            System.out.print("Input first line: ");
            line1 = reader.readLine();
            System.out.print("Input second line: ");
            line2 = reader.readLine();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong. Please, try again.");
            return;
        }
        boolean result;
        try {
            result = checker.checkWithArraySort(line1, line2);
        } catch (IllegalArgumentException e) {
            System.out.println("The lines are not the same length, they can't be anagrams.");
            return;
        }
        System.out.print("\"" + line1 + "\"" + " and \"" + line2 + "\" are");
        if (!result) {
            System.out.print(" not");
        }
        System.out.println(" anagrams.");
    }
}
