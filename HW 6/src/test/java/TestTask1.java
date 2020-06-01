
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestTask1 {

    private tasks test;

    @BeforeEach
    public void init() {
        test = new tasks();
    }

    //Проверка выброса исключения:
    @Test
    public void checkSomething() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            test.task1(new int[]{1, 1, 3, 2});
        });
    }

    //Проверка значений итогового массива:
    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void massTestAdd(int[] a, int []result) {
        Assertions.assertArrayEquals(result, test.task1(a));
    }

    public static Stream<Arguments> dataForAddOperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 3, 2}, new int[]{3, 2}));
        out.add(Arguments.arguments(new int[]{1, 1, 4, 2},       new int[]{2}));
        out.add(Arguments.arguments(new int[]{1, 4, 1, 1, 3, 2}, new int[]{1, 1, 3, 2}));
        out.add(Arguments.arguments(new int[]{4, 1, 1, 5, 3, 2}, new int[]{1, 1, 5, 3, 2}));

        return out.stream();
    }


}
