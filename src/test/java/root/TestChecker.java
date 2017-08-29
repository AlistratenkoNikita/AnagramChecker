package root;

import com.alistratenko.anagram.AnagramCheckerI;
import com.alistratenko.anagram.AnagramChecker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikita
 * @since 29.08.2017
 */
public class TestChecker {
    private AnagramCheckerI checker;

    @Before
    public void init() {
        checker = new AnagramChecker();
    }

    @Test
    public void casualTest() {
        assertTrue(checker.checkWithArraySort("repacks", "packers"));
        assertTrue(checker.checkWithArraySort("repRInt", "priNTer"));
        assertTrue(checker.checkWithArraySort("tRashed", "threAds"));
        assertTrue(checker.checkWithArraySort("SiLeNt CAT", "LisTen AcT"));
        assertFalse(checker.checkWithArraySort("cheaters", "teechers"));
        assertFalse(checker.checkWithArraySort("trAshEd", "thrEaD1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionHandlingTest() {
        checker.checkWithArraySort("Ivan", "Nikita");
    }

    @Test
    public void nullArgumentTest() {
        assertFalse(checker.checkWithArraySort(null, "a"));
        assertFalse(checker.checkWithArraySort("a", null));
        assertFalse(checker.checkWithArraySort(null, null));
    }

    @Test
    public void linesWithNonAlphanumericCharactersTest() {
        AnagramChecker anagramChecker = new AnagramChecker();
        assertTrue(anagramChecker.checkWithArraySort(
                "To be or not to be: that is the question; whether 'tis nobler in the mind to suffer " +
                        "the slings and arrows Of outrageous fortune, or to take arms against " +
                        "a sea of troubles and by opposing, end them?",
                "Is a befitting quote from one of Shakespeare's greatest tragedies. " +
                        "But why won't Hamlet's inspiring motto toss our stubborn hero's tortuous battle for life, " +
                        "on one hand, and death, on another?",
                true));
    }
}
