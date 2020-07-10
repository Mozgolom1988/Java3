package com.company;

public class Main {

    public static void main(String[] args) {

        //h Hanoi
        createHanoi(3);

        //h 8 Queens (не успел)

    }

    private static void createHanoi(int totalNumberOfCircle) {
        //создадим параметры для игры: три массива и заполним первый числами от 1,2,3,4... в зависимости от кол-во кругов
        int[] cell_1 = new int[totalNumberOfCircle];
        int[] cell_2 = new int[totalNumberOfCircle];
        int[] cell_3 = new int[totalNumberOfCircle];

        for (int i = 0; i <cell_1.length ; i++) {
            cell_1[i] = i + 1;
        }

        playHanoi(totalNumberOfCircle, cell_1,cell_2,cell_3)

        /*
        for (int i = 0; i <cell_1.length ; i++) {
            System.out.println(cell_1[i]);
        }
         */

    }

    private static void playHanoi(int totalNumberOfCircle, int[] cell_1, int[] cell_2, int[] cell_3) {
        boolean MakeStep = false;

        //проверка условия выхода из цикла(в последнем массиве лежат данные в нужном порядке):
        while (!testwin(cell_3)) {

            //if(cell_1[0] != 0) {
            //}






        }


    }

    private static boolean testwin(int[] cell_3) {
        boolean result = true;
        for (int i = 0; i < cell_3.length; i++) {
            if(cell_3[i] != i+1) {
                result =false;
                break;
            }
        }
        return result;
    }


}
