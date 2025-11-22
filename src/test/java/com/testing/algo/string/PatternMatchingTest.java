package com.testing.algo.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PatternMatchingTest {

    PatternMatching pm = new PatternMatching();

    @Test
    void testNaiveExactMatch() {
        assertEquals(0, pm.searchNaive("abc", "abc"));
        assertEquals(2, pm.searchNaive("xxabcxx", "abc"));
        assertEquals(5, pm.searchNaive("12345hello", "hello"));
    }

    @Test
    void testNaiveNoMatch() {
        assertEquals(-1, pm.searchNaive("abcdef", "gh"));
        assertEquals(-1, pm.searchNaive("aaaa", "aaab"));
    }

    @Test
    void testNaiveEdgeCases() {
        assertEquals(-1, pm.searchNaive(null, "a"));
        assertEquals(-1, pm.searchNaive("abc", null));
        assertEquals(-1, pm.searchNaive("abc", ""));
        assertEquals(-1, pm.searchNaive("", "a"));
    }

    @Test
    void testNaiveOverlapping() {
        assertEquals(0, pm.searchNaive("aaaaa", "aaa"));
    }

    @Test
    void testKMPExactMatch() {
        assertEquals(0, pm.searchKMP("abc", "abc"));
        assertEquals(5, pm.searchKMP("xxxxyabczz", "abc"));
    }

    @Test
    void testKMPNoMatch() {
        assertEquals(-1, pm.searchKMP("abcdef", "gh"));
        assertEquals(-1, pm.searchKMP("aaaa", "aaab"));
    }

    @Test
    void testKMPEdgeCases() {
        assertEquals(-1, pm.searchKMP(null, "a"));
        assertEquals(-1, pm.searchKMP("abc", null));
        assertEquals(-1, pm.searchKMP("abc", ""));
    }

    @Test
    void testKMPPatternLongerThanText() {
        assertEquals(-1, pm.searchKMP("abc", "abcd"));
    }

    @Test
    void testKMPOverlap() {
        assertEquals(0, pm.searchKMP("aaaaa", "aaa"));
    }

    @Test
    void testKMPMismatchFallback() {
        assertEquals(2, pm.searchKMP("ababcabc", "abc"));
    }
}
