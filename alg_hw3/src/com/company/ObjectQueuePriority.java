package com.company;

public class ObjectQueuePriority {
    private int value;
    private int priority;

    public ObjectQueuePriority(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }
}
