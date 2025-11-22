package com.testing.algo.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearSearchTest {

    LinearSearch ls = new LinearSearch();

    @Test
    public void testNull() {
        assertEquals(-1, ls.search(null, 5));
        assertEquals(-1, ls.searchFromEnd(null, 5));
    }

    @Test
    public void testNotFound() {
        assertEquals(-1, ls.search(new int[]{1,2,3}, 99));
        assertEquals(-1, ls.searchFromEnd(new int[]{1,2,3}, 99));
    }

    @Test
    public void testFoundBeginning() {
        assertEquals(0, ls.search(new int[]{5,6,7}, 5));
        assertEquals(0, ls.searchFromEnd(new int[]{5,6,7}, 5));
    }

    @Test
    public void testFoundMiddle() {
        assertEquals(1, ls.search(new int[]{5,6,7}, 6));
        assertEquals(1, ls.searchFromEnd(new int[]{5,6,7}, 6));
    }

    @Test
    public void testFoundEnd() {
        assertEquals(2, ls.search(new int[]{5,6,7}, 7));
        assertEquals(2, ls.searchFromEnd(new int[]{5,6,7}, 7));
    }

    @Test
    public void testSingle() {
        assertEquals(0, ls.search(new int[]{8}, 8));
        assertEquals(-1, ls.search(new int[]{8}, 4));
        assertEquals(0, ls.searchFromEnd(new int[]{8}, 8));
        assertEquals(-1, ls.searchFromEnd(new int[]{8}, 4));
    }
}
