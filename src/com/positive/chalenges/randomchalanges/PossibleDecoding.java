package com.positive.chalenges.randomchalanges;

class PossibleDecoding {

    int countDecodingCount(String numbers) {
        int current = 1;
        int p = 1;
        int pp = 1;
        for (int i = 0; i < numbers.length(); i++) {
            if (isSpecial(numbers, i)) {
                current = p + pp;
            }
            pp = p;
            p = current;
        }
        return current;
    }

    private boolean isSpecial(String numbers, int index) {
        return index < numbers.length() - 1 && (
                (numbers.charAt(index) == '1' && numbers.charAt(index + 1) != '0') ||
                        (numbers.charAt(index) == '2' && numbers.charAt(index + 1) >= '0' && numbers.charAt(index + 1) <= '6'));
    }

}
