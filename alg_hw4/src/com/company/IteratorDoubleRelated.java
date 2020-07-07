package com.company;

import FromWebinar.Cat;

public class IteratorDoubleRelated {
    private DoubleRelatedList list;
    private Node current;

    public IteratorDoubleRelated (DoubleRelatedList listForIterator){
        this.list = listForIterator;
        this.reset();
    }

    public void reset(){
        current = list.getHead();
    }

    public void next() {
        if(hasNext()) {
            current = current.next;
        }
    }

    public Cat getCurrent() {
        return current.c;
    }

    public boolean hasNext() { return current.next != null;}

    public boolean atEnd() {
        if (list.isEmpty()) return true;
        return current.next == null;
    }

    public void insertAfter(Cat c) {
        Node temp = new Node(c);
        int size = list.getSize();
        if(list.isEmpty()) {
            list.setHead(temp);
            list.setTail(temp);
        } else {
            temp.prev = current;
            temp.next = current.next;
            if (current == list.getTail()) {
                list.setTail(temp);
            }
            current.next = temp;
        }
        current = temp;
        list.setSize(++size);
    }

    public void insertBefore(Cat c) {
        Node temp = new Node(c);
        int size = list.getSize();
        if(list.isEmpty()) {
            list.setHead(temp);
            list.setTail(temp);
        } else {
            temp.next = current;
            temp.prev = current.prev;
            if (current == list.getHead()) {
                list.setHead(temp);
            }
            current.prev = temp;
        }
        current = temp;
        list.setSize(++size);
    }

    public boolean deleteCurrent() {
        if (list.isEmpty()) return false;

        int size = list.getSize();
        Node next = current.next;
        Node prev = current.prev;

        if (current == list.getHead()) {
            list.setHead(next);
        } else {
            prev.next = next;
        }

        if(atEnd()) {
            list.setTail(prev);
        } else {
            next.prev = prev;
        }

        if(hasNext()) current = next;
            else current = prev;

        list.setSize(--size);

        return true;
    }
}
