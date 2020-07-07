package com.company;

import FromWebinar.Cat;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
     DoubleRelatedList DB_test = new DoubleRelatedList();

     IteratorDoubleRelated iterator = new IteratorDoubleRelated(DB_test);

     iterator.insertAfter(new Cat(4,"Barsik4"));
     iterator.deleteCurrent();

     DB_test.pushHead(new Cat(3,"Barsik3"));
     DB_test.pushHead(new Cat(2,"Barsik2"));
     DB_test.pushHead(new Cat(1,"Barsik1"));

     DB_test.pushTail(new Cat(5,"Barsik5"));
     DB_test.popHead();
     DB_test.popTail();

     System.out.println(DB_test.toString());


    }
}
