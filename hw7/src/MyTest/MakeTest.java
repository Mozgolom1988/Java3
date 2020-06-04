package MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MakeTest {

    //На вход принимает имя класса
    public void start(String nameClass) {
        this.start(nameClass.getClass());
    }

    //На вход принимает класс
    public void start(Class c) throws RuntimeException{

        Method[] methods = c.getDeclaredMethods();

        Method BeforeSuite = null;
        Method AfterSuite = null;

        //Проверка методов BeforeSuite и AfterSuite и сохранение их значений
        for (Method m: methods) {
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
        }

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

        for (Method m: methods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
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
