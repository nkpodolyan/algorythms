package com.positive.datastructures.heap;


import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by mykola on 05.05.15.
 */
public class HeapTest {

    private BinaryHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new BinaryHeap<>();
    }

    @Test
    public void testInsertCounter() {
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        assertTrue(heap.size() == 10);
    }

    @Test
    public void testCorrectness() {
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        testHeapDataSet();
    }

    private void testHeapDataSet(){
        int max = heap.poll();
        while (!heap.isEmpty()){
            int current = heap.poll();
            assertTrue(current <= max);
            max = current;
        }
        System.out.println();
    }

    @Test
    public void hugeAmount() {
        Random random = new Random();
        int size = 1000000;
        for (int i = 0; i < size; i++) {
            heap.insert(random.nextInt());
        }
        assertTrue(heap.size() == size);
        testHeapDataSet();
    }

}
