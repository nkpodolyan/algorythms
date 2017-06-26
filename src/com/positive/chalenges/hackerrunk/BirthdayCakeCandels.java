package com.positive.chalenges.hackerrunk;

import java.util.Scanner;

/**
 * Created by mykola.podolian on 6/23/17.
 */
public class BirthdayCakeCandels {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxHeight = 0;
        int maxHeightCount = 0;
        while (n > 0) {
            n--;
            int height = scanner.nextInt();
            if (height > maxHeight) {
                maxHeight = height;
                maxHeightCount = 1;
            } else if (height == maxHeight) {
                maxHeightCount++;
            }
        }
        System.out.println(maxHeightCount);
    }
}
