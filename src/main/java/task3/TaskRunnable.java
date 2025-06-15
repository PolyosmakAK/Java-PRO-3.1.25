package task3;

import static task3.Util.printThreadName;
import static task3.Util.sleepSec;

public class TaskRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Запускаем задачу");
        printThreadName();
        sleepSec(5);
        System.out.println("Завершаем задачу");
    }
}
