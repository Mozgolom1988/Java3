package com.company;

import MyTest.MakeTest;

public class Main {

    public static void main(String[] args) {
        MakeTest a_test = new MakeTest();
        a_test.start(TestClass.class);

        System.out.println("Test done");
    }
}
