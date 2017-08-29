package com.alistratenko.anagram;

import java.util.Arrays;

/**
 * @author Nikita
 * @since 29.08.2017
 */
public class AnagramChecker implements AnagramCheckerI {

    /**
     * {@inheritDoc}
     * Deletes separation signs in both lines
     */
    @Override
    public boolean checkWithArraySort(String line1, String line2) throws IllegalArgumentException {
        if (checkLinesForNulls(line1, line2)) {
            return baseMethod(line1.replaceAll("\\s", ""), line2.replaceAll("\\s", ""));
        }
        return false;

    }

    /**
     * Same as {@link AnagramChecker#checkWithArraySort(String, String)} but has can delete all non alphanumeric characters
     * Made just for fun))))
     *
     * @param line1 first line to check
     * @param line2 second line to check
     * @return boolean value of result checking
     * @throws IllegalArgumentException throws if the lines are not the same length
     */
    public boolean checkWithArraySort(String line1, String line2, boolean deleteNonAlphanumericCharacters) throws IllegalArgumentException {
        if (checkLinesForNulls(line1, line2)) {
            if (deleteNonAlphanumericCharacters) {
                line1 = line1.replaceAll("[^a-zA-Z0-9]", "");
                line2 = line2.replaceAll("[^a-zA-Z0-9]", "");
            }
            return checkWithArraySort(line1, line2);
        }
        return false;
    }

    /**
     * Does main function - converts lines to char arrays, sorts them and compares unsing {@link Arrays#equals(char[], char[])} method
     *
     * @param line1 first line to check
     * @param line2 second line to check
     * @return logical result if input lines are anagrams
     */
    private boolean baseMethod(String line1, String line2) {
        if (line1.length() != line2.length()) {
            throw new IllegalArgumentException("Lines are not the same length");
        } else {
            char[] array1 = line1.toLowerCase().toCharArray();
            char[] array2 = line2.toLowerCase().toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            return Arrays.equals(array1, array2);
        }

    }

    /**
     * Checks both lines for being null
     *
     * @param line1 first line to check
     * @param line2 second line to check
     * @return boolean result of result checking
     */
    private boolean checkLinesForNulls(String line1, String line2) {
        return (line1 != null && line2 != null);
    }
}
