package com.company;

import java.util.NoSuchElementException;

public class Dequeue {
    private int capacity;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Dequeue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public void insertFirst(int value) {
        if (isFull()) {
            increaseCapacity();
        }

        int[] afterIndex = new int[capacity - head];
        System.arraycopy(queue, head, afterIndex, 0, capacity - head);
        queue[head] = value;
        System.arraycopy(afterIndex, 0, queue, head +1, afterIndex.length-1);

        if (tail == capacity - 1)
            tail = -1;
        else tail++;
        items++;
    }

    public void insertLast(int value) {
        if (isFull()) {
            increaseCapacity();
        }
        if (tail == capacity - 1)
            tail = -1;

        queue[++tail] = value;
        items++;
    }

    private void increaseCapacity() {
        capacity *= 2;
        int[] newQ = new int[capacity];
        if (tail >= head) {
            System.arraycopy(queue, 0, newQ, 0, queue.length);
        } else {
            System.arraycopy(queue, 0, newQ, 0, tail + 1);
            System.arraycopy(queue, head,
                    newQ, capacity - (queue.length - head),
                    queue.length - head - 1);
        }
        queue = newQ;
    }

    public int removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }

    public int removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[tail--];
        items--;
        return temp;
    }

    public int peekFirst() {
        return queue[head];
    }
    public int peekLast() {return queue[tail]; }
}
