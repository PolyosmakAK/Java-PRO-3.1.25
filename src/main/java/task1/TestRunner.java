package task1;

public class TestRunner {

    @AfterSuite
    static void staticMethodForAfter() {
        System.out.println("staticMethodForAfter");
    }

    @Test(priority = 1)
    void testOne() {
        System.out.println("priority 1");
    }

    @Test(priority = 5)
    void testFive() {
        System.out.println("priority 5");
    }

    @Test(priority = 2)
    void testTwo() {
        System.out.println("priority 2");
    }

    @BeforeSuite
    static void staticMethodForBefore() {
        System.out.println("staticMethodForBefore");
    }
}
