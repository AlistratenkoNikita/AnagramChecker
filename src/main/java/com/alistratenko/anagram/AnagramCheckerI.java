package com.alistratenko.anagram;

/**
 * An interface for a class that does checking 2 lines if they are the anagrams
 *
 * @author Nikita
 * @since 29.08.2017
 */
public interface AnagramCheckerI {
    /**
     * Checks two lines if they are anagrams
     *
     * @param line1 first line to check
     * @param line2 second line to check
     * @return boolean value of result checking
     * @throws IllegalArgumentException throws if the lines are not the same length
     */
    boolean checkWithArraySort(String line1, String line2) throws IllegalArgumentException;
}
