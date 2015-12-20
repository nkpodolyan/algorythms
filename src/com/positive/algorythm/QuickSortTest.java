package com.positive.algorythm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testPlainData() {
        int[] arr = new int[]{1, 2, 3, -13, 87, 93, 5, 7, 0, -1};
        quickSort.sort(arr);
        Assert.assertTrue(isSorted(arr));
    }

    @Test
    public void testSingleItemInput() {
        int[] arr = new int[]{1};
        quickSort.sort(arr);
        Assert.assertTrue(isSorted(arr));
    }

    @Test
    public void testTwoItemsInput() {
        int[] arr = new int[]{-7, 1};
        quickSort.sort(arr);
        Assert.assertTrue(isSorted(arr));
    }

    @Test
    public void testEmptyInput() {
        int[] arr = new int[]{};
        quickSort.sort(arr);
        Assert.assertTrue(isSorted(arr));
    }

    @Test
    public void testNullPointer() {
        try {
            quickSort.sort(null);
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail();
    }

    private boolean isSorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return Arrays.equals(arr, sorted);
    }

}
