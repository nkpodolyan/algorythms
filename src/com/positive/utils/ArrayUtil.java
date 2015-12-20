package com.positive.utils;

public class ArrayUtil {

    public static void swap(int[] arr, int f, int s) {
        int buff = arr[f];
        arr[f] = arr[s];
        arr[s] = buff;
    }

    public static void print(int[] arr) {
        print(arr, 0, arr.length - 1);
    }

    public static void print(int[] arr, int s, int e) {
        if (s > e) {
            return;
        }
        System.out.print("{");
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i]);
            if (i != e) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

}
