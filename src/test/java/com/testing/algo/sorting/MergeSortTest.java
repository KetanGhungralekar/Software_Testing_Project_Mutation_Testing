package com.testing.algo.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    MergeSort ms = new MergeSort();

    @Test
    public void testSort_Basic() {
        int[] arr = {5,3,1,4,2};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_AlreadySorted() {
        int[] arr = {1,2,3,4,5};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_ReverseSorted() {
        int[] arr = {5,4,3,2,1};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_WithDuplicates() {
        int[] arr = {3,1,3,2,1};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,1,2,3,3}, arr);
    }

    @Test
    public void testSort_AllEqual() {
        int[] arr = {7,7,7,7};
        ms.sort(arr);
        assertArrayEquals(new int[]{7,7,7,7}, arr);
    }

    @Test
    public void testSort_Null() {
        ms.sort(null);
    }

    @Test
    public void testSort_SingleElement() {
        int[] arr = {10};
        ms.sort(arr);
        assertArrayEquals(new int[]{10}, arr);
    }

    @Test
    public void testSort_PivotLeftHeavy() {
        int[] arr = {2,3,4,5,1};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_PivotRightHeavy() {
        int[] arr = {4,1,2,3,5};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_RemainderInLeftArray() {
        int[] arr = {1,4,5,2,3};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_RemainderInRightArray() {
        int[] arr = {2,3,1,9,8};
        ms.sort(arr);
        assertArrayEquals(new int[]{1,2,3,8,9}, arr);
    }
}
