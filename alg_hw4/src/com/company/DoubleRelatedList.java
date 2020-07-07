package com.company;

import FromWebinar.Cat;

public class DoubleRelatedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleRelatedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node getHead() { return head;}
    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushHead(Cat c) {
        Node n = new Node(c);
        n.next = head;
        if (!isEmpty()) {
            head.prev = n;
        }
            else tail =n;
        head = n;
        size++;
    }

    public void pushTail(Cat c) {
        Node n = new Node(c);
        n.prev = tail;
        if (!isEmpty()) tail.next = n;
            else head = n;
        tail = n;
        size++;
    }

    public Cat popHead() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    public Cat popTail() {
        if (isEmpty()) return null;
        Cat temp = tail.c;
        tail = tail.prev;
        tail.next = null;
        size--;
        return temp;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) == null;
    }

    private Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(Cat c) {
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            Node next = current.next;

            previous.next = next;
            next.prev = previous;
        }
        return true;
    }


}
