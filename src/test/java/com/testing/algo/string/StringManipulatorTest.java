package com.testing.algo.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StringManipulatorTest {

    StringManipulator sm = new StringManipulator();

    @Test
    void testReverseBasic() {
        assertEquals("cba", sm.reverse("abc"));
        assertEquals("", sm.reverse(""));
        assertNull(sm.reverse(null));
    }

    @Test
    void testReverseUnicode() {
        assertEquals("界世", sm.reverse("世界"));
        assertEquals("😊abc", sm.reverse("cba😊"));
    }

    @Test
    void testPalindromeBasic() {
        assertTrue(sm.isPalindrome("madam"));
        assertFalse(sm.isPalindrome("hello"));
    }

    @Test
    void testPalindromeWithSpaces() {
        assertTrue(sm.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testPalindromeEdge() {
        assertFalse(sm.isPalindrome(null));
        assertTrue(sm.isPalindrome(""));
        assertTrue(sm.isPalindrome("a"));
    }

    @Test
    void testAnagramBasic() {
        assertTrue(sm.isAnagram("listen", "silent"));
        assertFalse(sm.isAnagram("abc", "abcd"));
        assertTrue(sm.isAnagram("aabb", "baba"));
    }

    @Test
    void testAnagramEdge() {
        assertFalse(sm.isAnagram(null, "abc"));
        assertFalse(sm.isAnagram("abc", null));
        assertTrue(sm.isAnagram("", ""));
    }

    @Test
    void testLevenshteinBasic() {
        assertEquals(0, sm.levenshteinDistance("abc", "abc"));
        assertEquals(1, sm.levenshteinDistance("abc", "ab"));
        assertEquals(3, sm.levenshteinDistance("", "abc"));
    }

    @Test
    void testLevenshteinDifferentLengths() {
        assertEquals(1, sm.levenshteinDistance("ab", "cab"));
        assertEquals(2, sm.levenshteinDistance("test", "besty"));
    }

    @Test
    void testLevenshteinFullMatrix() {
        assertEquals(3, sm.levenshteinDistance("kitten", "sitting"));
    }

    @Test
    void testLevenshteinNull() {
        assertThrows(IllegalArgumentException.class, () -> sm.levenshteinDistance(null, "abc"));
        assertThrows(IllegalArgumentException.class, () -> sm.levenshteinDistance("abc", null));
    }
}
