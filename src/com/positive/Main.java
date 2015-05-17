package com.positive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(" ");
            int begin = Integer.valueOf(values[0]);
            int end = Integer.valueOf(values[1]);
            boolean found = false;
            for (int i = begin; i <= end; i++) {
                if (isMagic(i)) {
                    found = true;
                    System.out.print(i + " ");
                }
            }
            if (!found) {
                System.out.print("-1");
            }
            System.out.println();
        }
    }

    private static boolean isMagic(int number) {
        List<Integer> digits = new ArrayList<>();
        do {
            int digit = number % 10;
            if (digit == 0 || digits.contains(digit)) {
                return false;
            }
            digits.add(digit);
            number /= 10;
        } while (number > 0);
        int currentIndex = digits.size() - 1;
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(currentIndex);
            digits.set(currentIndex, -1);
            if (digit == -1) {
                return false;
            }
            digit = digit % digits.size();
            if (digit > currentIndex) {
                currentIndex = digits.size() + currentIndex - digit;
            } else {
                currentIndex = currentIndex - digit;
            }
        }
        return currentIndex == digits.size() - 1;
    }

}
