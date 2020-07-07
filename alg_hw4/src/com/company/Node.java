package com.company;

import FromWebinar.Cat;
import java.util.Objects;

public class Node {
    Cat c;
    Node next;
    Node prev;

    public Node(Cat c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return c.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return c.equals(node.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}
