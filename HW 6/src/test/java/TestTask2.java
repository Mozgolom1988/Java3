import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestTask2 {

    private tasks test;

    @BeforeEach
    public void init() {
        test = new tasks();
    }

    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void massTestAdd(int[] a, boolean result) {
        Assertions.assertEquals(result, test.task2(a));
    }

    public static Stream<Arguments> dataForAddOperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4,1,4,1,1}, true));
        out.add(Arguments.arguments(new int[]{1, 3,5,1}, false));

        return out.stream();
    }
}
