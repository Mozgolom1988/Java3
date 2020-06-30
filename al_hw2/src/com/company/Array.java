package com.company;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set (int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    // homework
    public void insert(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        int[] afterIndex = new int[size-index];
        System.arraycopy(arr,index,afterIndex,0, size-index);

        if (size+1>= arr.length) {
            increaseCapacity();
        }
        arr[index] = value;
        System.arraycopy(afterIndex,0,arr,index+1, afterIndex.length);
        size++;
        isSorted = false;
    }

    //изменил название delete так как нельзя иметь два одинаковых метода "delete";
    public void deleteValue(int val) {
        int deletedIndex = 0;

        //Удалим первое найденное значение
        for (int i = 0; i < size; i++) {
            if (val == arr[i]){
                delete(i);
                break;
            }
        }

    }

    public int delete(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        //получим удаляемый элемент:
        int result = arr[index];
        size--;

        for (int i = index; i < size; i++) {
            arr[i] = arr[i+1];
        }
        return result;
    }

    public void deleteAll() {
        //удалить все = оставить пустой массив
        size = 0;
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int sortBubble() {
        int CountOperation = 0;

        //Оптимизация
        //1. Первый цикл достаточно size-1: так как всего элементов size, а сравнение нужно только size-1 раз;
        //2. Во втором цикле уменьшаем количество обходов на -1 при каждом цикле (последний элемент всегда эталонный);

        int BubbleSize = size-1;

        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < BubbleSize; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
                    CountOperation++;
            }
            BubbleSize--;
        }
        isSorted = true;

        return  CountOperation;
    }

    public int sortSelect() {
        int CountOperation = 0;

        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            swap(flag, cMin);
            CountOperation++;
        }
        isSorted = true;
        return  CountOperation;
    }

    public int sortInsert() {
        int CountOperation = 0;

        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
                CountOperation++;
            }
            arr[in] = temp;
        }
        isSorted = true;

        return  CountOperation;
    }


    public int sortCount() {
        int CountOperation = 0;

        //Ограничение, что разница между минимальным и максимальным значением меньше 10
        //найдем минимальное значение для первого элемента вспомогательного массива:
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if(max <arr[i]) {
                max = arr[i];
            }
            CountOperation++;
        }

        if( (max-min) >10) {
            new RuntimeException("Использование метода невозможно, так как разница между минимальным и максимальным значением в массиве больше 10 !");
        }

        int[] HelpSort= new int[11];
        for (int i = 0; i < size; i++) {
            HelpSort[arr[i]-min]++;
            CountOperation++;
        }

        int curIndex = 0;

        for (int i = 0; i < HelpSort.length; i++) {
            if(HelpSort[i] !=0) {
                for (int j = 0; j < HelpSort[i]; j++) {
                 arr[curIndex++] = min + i;
                    CountOperation++;
                }
            }
        }


        isSorted = true;
        return CountOperation++;
    }

}
