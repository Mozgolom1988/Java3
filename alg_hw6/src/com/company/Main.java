package com.company;

public class Main {

    public static void main(String[] args) {

        int unBalanceTree = 0;

        for (int i = 0; i < 6; i++) {
            Tree newTree = createTree();
            if(checkBalance(newTree)) unBalanceTree++;
        }

    }

    private static Tree createTree() {
        //Пока текущий уровень не равен 6 создаем дерево из случайных чисел от -100 до 100:
        int currentTreeLevel = 0;
        Tree myTree = new Tree();

        while (currentTreeLevel != 6){
            int randomNumber = -100 + (int) (Math.random() * 200);
            Cat c = new Cat(randomNumber,"barsik");
            myTree.insert(c);
            currentTreeLevel = myTree.getCurrentLevel();

        }

            return myTree;
    }

    private static boolean checkBalance(Tree newTree) {
        return false;
    }


}
