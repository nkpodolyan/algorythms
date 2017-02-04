package com.positive.algorythm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class DutchFlagSortTest {

    private DutchFlagSort sort;

    @Before
    public void setUp() {
        sort = new DutchFlagSort();
    }

    @Test
    public void testRegularCase() {
        int[] data = new int[]{5, 3, 4, 2, 3, 0};
        sort.sort(data, 3);
        int[] expected = new int[]{0, 2, 3, 3, 4, 5};
        assertEquals(data, expected);
    }

    @Test
    public void testLittleData() {
        int[] data = new int[]{5, 3};
        sort.sort(data, 3);
        int[] expected = new int[]{3, 5};
        assertEquals(data, expected);
    }

    @Test
    public void testLongData() {
        int[] data = new int[]{5, 3, 2, 8, 4, 0, 1, 3, 5, 3, -1};
        sort.sort(data, 3);
        int[] expected = new int[]{-1, 2, 0, 1, 3, 3, 3, 5, 4, 8, 5};
        assertEquals(data, expected);
    }

    private void assertEquals(int[] d1, int d2[]) {
        boolean equals = Arrays.equals(d1, d2);
        Assert.assertTrue("Arrays are not equals\n" + toString(d1) + "\n" + toString(d2), equals);
    }

    private String toString(int[] d) {
        String s = "[";
        for (int i : d) {
            s += " " + i + ",";
        }
        s += "]";
        return s;
    }
}
