package com.testing.algo.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    BinarySearch bs = new BinarySearch();

    @Test
    public void testNull() {
        assertEquals(-1, bs.search(null, 5));
        assertEquals(-1, bs.searchRecursive(null, 5));
    }

    @Test
    public void testNotFound() {
        int[] arr = {1,2,3,4,5};
        assertEquals(-1, bs.search(arr, 99));
        assertEquals(-1, bs.searchRecursive(arr, 99));
    }

    @Test
    public void testFoundBeginning() {
        int[] arr = {1,2,3,4,5};
        assertEquals(0, bs.search(arr, 1));
        assertEquals(0, bs.searchRecursive(arr, 1));
    }

    @Test
    public void testFoundMiddle() {
        int[] arr = {1,2,3,4,5};
        assertEquals(2, bs.search(arr, 3));
        assertEquals(2, bs.searchRecursive(arr, 3));
    }

    @Test
    public void testFoundEnd() {
        int[] arr = {1,2,3,4,5};
        assertEquals(4, bs.search(arr, 5));
        assertEquals(4, bs.searchRecursive(arr, 5));
    }

    @Test
    public void testSingleElement() {
        int[] arr = {7};
        assertEquals(0, bs.search(arr, 7));
        assertEquals(-1, bs.search(arr, 2));
        assertEquals(0, bs.searchRecursive(arr, 7));
        assertEquals(-1, bs.searchRecursive(arr, 2));
    }

    @Test
    public void testTwoElements() {
        int[] arr = {5,10};
        assertEquals(0, bs.search(arr, 5));
        assertEquals(1, bs.search(arr, 10));
        assertEquals(0, bs.searchRecursive(arr, 5));
        assertEquals(1, bs.searchRecursive(arr, 10));
    }
}
