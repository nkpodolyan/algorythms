package com.positive.algorythm;

public class DutchFlagSort {

    public void sort(int[] data, int val) {
        int l = 0;
        int r = data.length - 1;
        int c = 0;
        while (c <= r) {
            if (data[c] > val) {
                swap(data, c, r);
                r--;
            } else if (data[c] < val) {
                swap(data, c, l);
                l++;
                c++;
            } else {
                c++;
            }
        }
    }

    private void swap(int[] d, int f, int s) {
        int buff = d[f];
        d[f] = d[s];
        d[s] = buff;
    }

}
