package com.positive.datastructures.heap;

import java.util.Arrays;

/**
 * Created by mykola on 05.05.15.
 */
public class BinaryHeap<E extends Comparable<E>> {

    private int size;

    private Object[] heap;

    public BinaryHeap() {
        heap = new Object[10];
    }

    public void insert(E e) {
        ensureCapacity();
        heap[size] = e;
        swim(size);
        size++;
    }

    public E poll() {
        if (size > 0) {
            E element = (E) heap[0];
            heap[0] = heap[--size];
            heap[size] = null;
            sync(0);
            shrinkToCapacity();
            return element;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void swim(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            E current = (E) heap[index];
            E parent = (E) heap[parentIndex];
            if (current.compareTo(parent) > 0) {
                exchange(index, parentIndex);
                index = parentIndex;
            } else {
                return;
            }
        }
    }

    private void sync(int index) {
        while (index * 2 + 1 < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int indexToSync;
            if(right < size){
                indexToSync = compare(left, right) > 0 ? left : right;
            } else {
                indexToSync = left;
            }
            if (compare(index, indexToSync) < 0) {
                exchange(index, indexToSync);
                index = indexToSync;
            } else {
                return;
            }
        }
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    private void shrinkToCapacity() {
        if (heap.length > 10 && heap.length >= size * 4) {
            heap = Arrays.copyOf(heap, heap.length / 2);
        }
    }

    private int compare(int f, int s) {
        return ((E) heap[f]).compareTo((E) heap[s]);
    }

    private void exchange(int f, int s) {
        Object buff = heap[f];
        heap[f] = heap[s];
        heap[s] = buff;
    }
}
