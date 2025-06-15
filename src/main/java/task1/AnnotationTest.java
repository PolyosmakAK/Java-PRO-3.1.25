package task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnnotationTest {

    public static void main(String[] args) {
        List<Method> methodListTest = new ArrayList<>();
        List<Method> methodListBeforeSuite = new ArrayList<>();
        List<Method> methodListAfterSuite = new ArrayList<>();

        TestRunner runnerTest = new TestRunner();
        Class<TestRunner> testRunner = TestRunner.class;
        var methods = testRunner.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                if (method.getAnnotation(Test.class).priority() > 0 || method.getAnnotation(Test.class).priority() < 11) {
                    methodListTest.add(method);
                } else {
                    throw new IllegalStateException("Error Test priority not range 1 - 10");
                }
            } else if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (method.getModifiers() == Modifier.STATIC) methodListBeforeSuite.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (method.getModifiers() == Modifier.STATIC) methodListAfterSuite.add(method);
            }
        }

        if (methodListBeforeSuite.size() == 1) {
            invokeUtil(methodListBeforeSuite.getFirst(), runnerTest);
        } else if (methodListBeforeSuite.size() > 1) {
            throw new IllegalStateException("Error BeforeSuite more 1");
        }

        methodListTest.stream().sorted(Comparator.comparing(method1 -> method1.getAnnotation(Test.class).priority()))
                .forEach(x -> invokeUtil(x, runnerTest));
        if (methodListAfterSuite.size() == 1) {
            invokeUtil(methodListAfterSuite.getFirst(), runnerTest);
        } else if (methodListAfterSuite.size() > 1) {
            throw new IllegalStateException("Error AfterSuite more 1");
        }
    }

    static void invokeUtil(Method method, Object object) {
        try {
            method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}