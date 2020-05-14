import java.util.ArrayList;
import java.util.Arrays;

public class Main  {

    public static void main(String[] args) {

        //Проверка задания 1:
        Number[] a = {5f, 5,15,25};
        changePlace(a);

        //Проверка задания 2:
        ArrayList<?> result= arrayToArrayList(a);

        //Задание 3:
        Box box1 = new Box();
        box1.putFruit(new Apple());
        box1.putFruit(new Apple());
        box1.putFruit(new Apple());

        Box box2 = new Box();
        box2.putFruit(new Orange());
        box2.putFruit(new Orange());

        System.out.println("Коробка 1 размер: " + box1.boxFruit.size() + " вес: " + box1.getWeight());
        System.out.println("Коробка 2размер: " + box2.boxFruit.size() + " вес: " + box2.getWeight());

        System.out.println("Коробки 1 и 2 равны: " + (box1.compareTo(box2)==0));

        Box box3 = new Box();
        box1.replaceFruit(box3);
        System.out.println("Коробка 3размер: " + box3.boxFruit.size() + " вес: " + box3.getWeight());

    }

    //Задание 1: Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
    private static void changePlace(Object[] arrays) {
        if (arrays.length<2)  {
            //длина массива меньше двух ничего не делаем
        } else {
            System.out.println("До перестановки    первый элемент: " + arrays[0] + ", второй: " + arrays[1]);
            Object b = arrays[1];
            arrays[1] = arrays[0];
            arrays[0] = b;
            System.out.println("После перестановки первый элемент: " + arrays[0] + ", второй: " + arrays[1]);
        }
    }

    //Задание 2: Написать метод, который преобразует массив в ArrayList;
    private static ArrayList<?> arrayToArrayList(Object[] a) {
        ArrayList<Object> ArrayListresult = new ArrayList(Arrays.asList(a));

        System.out.println(ArrayListresult);
        return ArrayListresult;

    }
}
