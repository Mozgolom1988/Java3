package com.company;

import MyTest.MakeTest;

public class Main {

    public static void main(String[] args) {
       int s =0;
       int t = 0;
       int[] a = {8,4,3,0,7,2,1,5,9,6};

        for (int j = 0; j < 9; j++) {
            if(a[j] <a[j+1]) {
                s++;
                t=a[j];
                a[j]=a[j+1];
                a[j+1]=t;
                }

        }

        System.out.println(s);


        // MakeTest a_test = new MakeTest();
       // a_test.start(TestClass.class);
    }
}
