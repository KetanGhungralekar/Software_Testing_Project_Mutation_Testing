package com.testing.algo.string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringTests {

    @Test
    void testStringManipulator() {
        StringManipulator sm = new StringManipulator();

        assertEquals("cba", sm.reverse("abc"));
        assertTrue(sm.isPalindrome("racecar"));
        assertFalse(sm.isPalindrome("hello"));

        assertTrue(sm.isAnagram("listen", "silent"));
        assertFalse(sm.isAnagram("hello", "world"));

        assertEquals(3, sm.levenshteinDistance("kitten", "sitting"));
    }

    @Test
    void testPatternMatching() {
        PatternMatching pm = new PatternMatching();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";

        assertEquals(10, pm.searchNaive(txt, pat));
        assertEquals(10, pm.searchKMP(txt, pat));

        assertEquals(-1, pm.searchNaive(txt, "XYZ"));
        assertEquals(-1, pm.searchKMP(txt, "XYZ"));
    }
}
