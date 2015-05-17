package com.positive.datastructures.tst;

import com.positive.datastructures.heap.BinaryHeap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mykola on 17.05.15.
 */
public class TstSetTest {

    private TSTSet<Integer> tstSet;

    @Before
    public void setUp() {
        tstSet = new TSTSet<>();
    }

    @Test
    public void testPut() {
        tstSet.put("sea", 1);
        tstSet.put("sta", 2);
        tstSet.put("some long phrase", 28);
        assertTrue(1 == tstSet.get("sea"));
        assertTrue(2 == tstSet.get("sta"));
        assertTrue(28 == tstSet.get("some long phrase"));
        assertTrue(tstSet.get("storm") == null);
    }

    @Test
    public void remove() {
        tstSet.put("sea", 1);
        tstSet.put("sebel", 2);
        tstSet.put("sec", 3);
        tstSet.remove("sea");
        assertTrue(null == tstSet.get("sea"));
        assertTrue(2 == tstSet.get("sebel"));
        assertTrue(3 == tstSet.get("sec"));
    }

}
