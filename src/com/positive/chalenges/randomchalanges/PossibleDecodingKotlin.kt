package com.positive.chalenges.randomchalanges

internal class PossibleDecodingKotlin {

    fun countDecodingCount(numbers: String): Int {
        var current = 1
        var p = 1
        var pp = 1
        for (i in 0..numbers.length - 1) {
            if (isSpecial(numbers, i)) {
                current = p + pp
            }
            pp = p
            p = current
        }
        return current
    }

    private fun isSpecial(numbers: String, index: Int): Boolean {
        return index < numbers.length - 1 && (numbers[index] == '1' && numbers[index + 1] != '0' || numbers[index] == '2' && numbers[index + 1] >= '0' && numbers[index + 1] <= '6')
    }

}
