package com.company;

public class Main {

    public static void main(String[] args) {

        //h Hanoi:
        //задача о ханонской башни ключ в формулировке:
        //Есть три стержня, на одном из них есть кольца;
        //Кольца всегда нанизаны меньшее на большем
        //1) Можно брать одно кольцо за 1 ход
        //2) Нельзя класть большее на меньшее
        createHanoi(3);

        //h 8 Queens:
        //
        //
        //
        //
        //

    }

    private static void createHanoi(int totalNumberOfCircle) {
        //создадим параметры для игры: три массива и заполним первый числами от 1,2,3,4... в зависимости от кол-во кругов
        int[] cell_1 = new int[totalNumberOfCircle];
        int[] cell_2 = new int[totalNumberOfCircle];
        int[] cell_3 = new int[totalNumberOfCircle];

        for (int i = 0; i <cell_1.length ; i++) {
            cell_1[i] = i + 1;
        }

        //playHanoi(totalNumberOfCircle, cell_1,cell_2,cell_3)

        for (int i = 0; i <cell_1.length ; i++) {
            System.out.println(cell_1[i]);
        }

    }

    private static void playHanoi(int totalNumberOfCircle, int[] cell_1, int[] cell_2, int[] cell_3) {
        boolean MakeStep = false;
        int from  = 0;
        int to =0;

        //проверка условия выхода из цикла(в последнем массиве лежат данные в нужном порядке):
        while (!testwin(cell_3)) {

            for (int i = 0; i < cell_3.length; i++) {
                
            }

        }


    }

    private static void makeStep(int[] cell_from, int[] cell_to) {
        for (int i = 0; i < cell_from.length; i++) {
            if (cell_from[i] !=0) {
                for (int j = cell_to.length; j > 0 ; j--) {
                   if(cell_to[j]==0){
                       cell_to[j] = cell_from[i];
                       break;
                   }
                }
                cell_from[i] =0;
                break;
            }
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
