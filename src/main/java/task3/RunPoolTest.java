package task3;

public class RunPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutorJavaPro javaPro = new ThreadPoolExecutorJavaPro(3);
        TaskRunnable runnable = new TaskRunnable();
        for (int x = 0; x < 4; x++) {
            javaPro.execute(runnable);
        }
    }
}
