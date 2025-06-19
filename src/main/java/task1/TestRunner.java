package task1;

import task1.annotation.AfterSuite;
import task1.annotation.BeforeSuite;
import task1.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    static List<Method> methodListTest = new ArrayList<>();
    static List<Method> methodListBeforeSuite = new ArrayList<>();
    static List<Method> methodListAfterSuite = new ArrayList<>();

    public static void runTests(Class<?> c) {
        Object object;
        try {
            object = c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        var methods = c.getDeclaredMethods();
        var countBeforeSuite = Arrays.stream(methods).filter(x -> x.isAnnotationPresent(BeforeSuite.class)).count();
        var countAfterSuite = Arrays.stream(methods).filter(x -> x.isAnnotationPresent(AfterSuite.class)).count();
        if (countBeforeSuite > 1 || countAfterSuite > 1) {
            throw new IllegalStateException("Error BeforeSuite or AfterSuite more 1");
        }
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

        invokeUtil(methodListBeforeSuite.getFirst(), c);

        methodListTest.stream().sorted(Comparator.comparing(method1 -> method1.getAnnotation(Test.class).priority()))
                .forEach(m -> invokeUtil(m, object));

        invokeUtil(methodListAfterSuite.getFirst(), c);
    }

    static void invokeUtil(Method method, Object c) {
        try {
            method.invoke(c);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}