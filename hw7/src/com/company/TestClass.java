package com.company;

import MyTest.AfterSuite;
import MyTest.BeforeSuite;
import MyTest.Test;

public class TestClass {

    @BeforeSuite
    public static void test_before(){
        System.out.println("test before");
    }

    @AfterSuite
    public static void test_after(){
        System.out.println("test after");
    }

    @Test(priority = 1)
    public static void test_p1(){
        System.out.println("test 1");
    }

    @Test(priority = 3)
    public static void test_p3(){
        System.out.println("test 3");
    }

    //priority default 5
    @Test
    public static void test_p5(){
        System.out.println("test 5");
    }
}
