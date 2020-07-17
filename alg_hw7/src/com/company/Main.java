package com.company;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('j');
        g.addVertex('i');
        g.addVertex('h');

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);

        g.addEdge(3,1);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(3,8);
        g.addEdge(3,9);

        g.addEdge(4,10);

        g.widthTraverse();


    }
}
