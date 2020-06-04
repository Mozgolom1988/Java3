package MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class MakeTest {

    //На вход принимает имя класса
    public void start(String nameClass) {
        this.start(nameClass.getClass());
    }

    //На вход принимает класс
    public void start(Class c) throws RuntimeException{

        ArrayList<Method> methods = new ArrayList<>();
        Method BeforeSuite = null;
        Method AfterSuite  = null;

        //Проверка методов BeforeSuite и AfterSuite и сохранение их значений
        for (Method m: c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if(BeforeSuite ==null) {
                    BeforeSuite = m;
                } else {
                    throw new RuntimeException("В классе имеется больше 1 метода с аннтоацией BeforeSuite");
                }
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {
                if(AfterSuite ==null) {
                    AfterSuite = m;
                } else {
                    throw new RuntimeException("В классе имеется больше 1 метода с аннтоацией BeforeSuite");
                }
            }

            if (m.isAnnotationPresent(Test.class)) {
                if(m.getAnnotation(Test.class).priority() < 1 || m.getAnnotation(Test.class).priority()>10){
                    throw new RuntimeException("В классе имеется методы с приоритетом не от 1 до 10");
                } else {
                    methods.add(m);
                }
            }
        }

        //Приоритет 1 - наивысший, 10 - наименьший
        methods.sort((o1, o2) -> o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority());

        //Запуск теста:
        if(BeforeSuite !=null) {
            try {
                BeforeSuite.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        for (Method testm: methods) {
                try {
                    testm.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        }

        if(AfterSuite !=null) {
            try {
                AfterSuite.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }

}
