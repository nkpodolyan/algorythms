package com.positive.algorythm;

import com.positive.utils.ArrayUtil;

public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException();
        partition(arr, 0, arr.length - 1);
    }

    private void partition(int[] arr, int start, int end) {
        if (start >= end) return;
        int pV = arr[(start + end) / 2];
        int l = start;
        int r = end;
        while (l <= r) {
            while (arr[l] < pV) l++;
            while (arr[r] > pV) r--;
            if (l <= r) ArrayUtil.swap(arr, l++, r--);
        }
        partition(arr, start, r);
        partition(arr, l, end);
    }

}
