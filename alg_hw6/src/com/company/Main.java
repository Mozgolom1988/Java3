package com.company;

public class Main {

    public static void main(String[] args) {

        int totalTree = 20;
        int unBalanceTree = 0;

        for (int i = 0; i < totalTree; i++) {
            Tree newTree = createTree();
            if(newTree.checkBalance()) unBalanceTree++;
        }

        System.out.println("Процент несбалансированных деревьев : " + (double)(unBalanceTree*100/totalTree) + "%");

    }

    private static Tree createTree() {
        //Пока текущий уровень не равен 6 создаем дерево из случайных чисел от -100 до 100:
        int currentTreeLevel = 0;
        Tree myTree = new Tree();

        //первый уровень 0, значит анализируем когда будет всего 5 уровней.
        while (currentTreeLevel != 5){
            int randomNumber = -100 + (int) (Math.random() * 200);
            Cat c = new Cat(randomNumber,"barsik");
            myTree.insert(c);

            currentTreeLevel = myTree.findMaxLevel();
        }

        //myTree.displayTree();

        return myTree;
    }


}
