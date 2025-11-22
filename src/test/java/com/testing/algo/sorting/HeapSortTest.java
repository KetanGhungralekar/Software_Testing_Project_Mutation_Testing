package com.testing.algo.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    HeapSort hs = new HeapSort();

    @Test
    public void testSort_Basic() {
        int[] arr = {5,3,1,4,2};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_AlreadySorted() {
        int[] arr = {1,2,3,4,5};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_ReverseSorted() {
        int[] arr = {5,4,3,2,1};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_WithDuplicates() {
        int[] arr = {3,1,3,2,1};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,1,2,3,3}, arr);
    }

    @Test
    public void testSort_AllEqual() {
        int[] arr = {7,7,7,7};
        hs.sort(arr);
        assertArrayEquals(new int[]{7,7,7,7}, arr);
    }

    @Test
    public void testSort_Null() {
        hs.sort(null);
    }

    @Test
    public void testSort_SingleElement() {
        int[] arr = {9};
        hs.sort(arr);
        assertArrayEquals(new int[]{9}, arr);
    }

    @Test
    public void testSort_LeftHeavyHeap() {
        int[] arr = {10,9,8,7,6,5,4};
        hs.sort(arr);
        assertArrayEquals(new int[]{4,5,6,7,8,9,10}, arr);
    }

    @Test
    public void testSort_RightHeavyHeap() {
        int[] arr = {10,1,2,3,4,5,6};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,10}, arr);
    }

    @Test
    public void testSort_RequiresDeepRecursion() {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    public void testSort_HeapifyRightPath() {
        int[] arr = {1,9,8,7,6,5,4};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,4,5,6,7,8,9}, arr);
    }

    @Test
    public void testSort_HeapifyLeftPath() {
        int[] arr = {1,8,9,7,6,5,4};
        hs.sort(arr);
        assertArrayEquals(new int[]{1,4,5,6,7,8,9}, arr);
    }
}
