package com.testing.algo.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchingTests {

    @Test
    void testLinearSearch() {
        LinearSearch searcher = new LinearSearch();
        int[] arr = { 2, 3, 4, 10, 40 };
        assertEquals(3, searcher.search(arr, 10));
        assertEquals(-1, searcher.search(arr, 50));
        assertEquals(-1, searcher.search(null, 10));
    }

    @Test
    void testBinarySearch() {
        BinarySearch searcher = new BinarySearch();
        int[] arr = { 2, 3, 4, 10, 40 };
        assertEquals(3, searcher.search(arr, 10));
        assertEquals(-1, searcher.search(arr, 50));

        assertEquals(3, searcher.searchRecursive(arr, 10));
        assertEquals(-1, searcher.searchRecursive(arr, 50));
    }

    @Test
    void testJumpSearch() {
        JumpSearch searcher = new JumpSearch();
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
        assertEquals(10, searcher.search(arr, 55));
        assertEquals(-1, searcher.search(arr, 56));
    }
}
