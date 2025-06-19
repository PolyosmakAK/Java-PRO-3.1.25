package task1;

import task1.annotation.AfterSuite;
import task1.annotation.BeforeSuite;
import task1.annotation.Test;

public class MyTests {

    @AfterSuite
    static void staticMethodForAfter() {
        System.out.println("staticMethodForAfter");
    }

    @Test(priority = 1)
    public void testOne() {
        System.out.println("priority 1");
    }

    @Test(priority = 4)
    public void testFive() {
        System.out.println("priority 4");
    }

    @Test(priority = 2)
    public void testTwo() {
        System.out.println("priority 2");
    }

    @BeforeSuite
    static void staticMethodForBefore() {
        System.out.println("staticMethodForBefore");
    }
}
