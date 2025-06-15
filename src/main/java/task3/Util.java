package task3;

public class Util {

    public static void sleepSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printThreadName(){
        System.out.printf("Имя потока - %s\n", Thread.currentThread().getName());
    }
}
