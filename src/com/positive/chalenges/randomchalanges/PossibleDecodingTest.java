package com.positive.chalenges.randomchalanges;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PossibleDecodingTest {

    private PossibleDecoding possibleDecoding;

    @Before
    public void setUp() {
        possibleDecoding = new PossibleDecoding();
    }

    @Test
    public void testTrivial() {
        Assert.assertEquals(5, possibleDecoding.countDecodingCount("1212"));
    }

    @Test
    public void testShort3() {
        Assert.assertEquals(3, possibleDecoding.countDecodingCount("121"));
    }

    @Test
    public void testShort2() {
        Assert.assertEquals(3, possibleDecoding.countDecodingCount("120"));
    }

    @Test
    public void testNoSpecialChars() {
        Assert.assertEquals(1, possibleDecoding.countDecodingCount("341052910"));
    }
}
