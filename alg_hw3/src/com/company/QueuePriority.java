package com.company;

import java.util.NoSuchElementException;

public class QueuePriority {
    private int capacity;
    private ObjectQueuePriority[] queue;
    private int head;
    private int tail;
    private int items;

    public QueuePriority(int capacity) {
        this.capacity = capacity;
        queue = new ObjectQueuePriority[capacity];
        head = 0;
        tail = -1;
        items = 0;
    }

    public int getItems() {
        return items;
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

    public void insert(int value, int priority) {
        if (isFull()) {
            capacity *= 2;
            ObjectQueuePriority[] newQ = new ObjectQueuePriority[capacity];
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

        //Вставим значение очередь приоритета: 1-наименьший приоритет, 10 - наивысший;
        //так как значения уходят с головы, поэтому начинаем анализ приоритетов с головы
        if (tail ==-1) {
            queue[++tail] = new ObjectQueuePriority(value, priority);
        } else {

            int index = tail;
            if (tail >= head) {
                index = findIndex(priority, head, tail);
            } else {
                index = findIndex(priority, tail, head);
            }
            ;

            if (tail == capacity - 1)
                tail = -1;
            tail++;

            ObjectQueuePriority[] afterIndex = new ObjectQueuePriority[capacity - index];
            System.arraycopy(queue, index, afterIndex, 0, capacity - index);
            queue[index] = new ObjectQueuePriority(value, priority);
            System.arraycopy(afterIndex, 0, queue, index +1, afterIndex.length-1);
        }

        items++;
    }

    private int findIndex(int priority, int begin, int end){
        int index = tail;
        for (int i = begin; i <= end; i++) {
            if(queue[i].getPriority() < priority) {
                index = i;
                break;
            }
        }
        return index;
    }

    public ObjectQueuePriority remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");

        ObjectQueuePriority temp = queue[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }

    public ObjectQueuePriority peek() {
        return queue[head];
    }
}
