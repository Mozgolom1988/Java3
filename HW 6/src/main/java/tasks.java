import java.util.Arrays;

public class tasks {

    public static void main(String[] args) {

        int[] test_array = task1(new int[]{1, 1, 4, 3, 3, 2});
        System.out.println(Arrays.toString(test_array));

        boolean res2 = task2(new int[]{1, 1});
        System.out.println(res2);
    }

    public static int[] task1 (int[] arrayIn) throws RuntimeException{

        for (int i = arrayIn.length-1; i >= 0; i--) {
            if(arrayIn[i] == 4) {
                return Arrays.copyOfRange(arrayIn, i+1, arrayIn.length);
            }
        }

        throw new RuntimeException("В входящем массиве нету 4!");
    }

    public static boolean task2 (int[] array) {

        boolean have1 = false;
        boolean have4 = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                have1 = true;
            } else if (array[i] == 4) {
                have4 = true;
            } else {
                return false;
            }
        }

        return have1 & have4;
    }


}
