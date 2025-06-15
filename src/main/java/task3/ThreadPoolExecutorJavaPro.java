package task3;

import java.util.LinkedList;

public class ThreadPoolExecutorJavaPro {
    private final Object monitor = new Object();
    private final LinkedList<Runnable> runnableLinkedList;
    private boolean isShutdown = false;


    public ThreadPoolExecutorJavaPro(int capacity) {
        runnableLinkedList = new LinkedList<>();
        WorkersThread[] workersThreads = new WorkersThread[capacity];
        for (int i = 0; i < capacity; i++) {
            workersThreads[i] = new WorkersThread();
            workersThreads[i].start();
        }
    }

    public synchronized void execute(Runnable task) {
        synchronized (monitor) {
            if (isShutdown) throw new IllegalStateException("Error shut down pool thread");
            runnableLinkedList.add(task);
            monitor.notify();
        }
    }

    public synchronized void shutdown() {
        synchronized (monitor) {
            isShutdown = true;
            notifyAll();
        }
    }

    private class WorkersThread extends Thread {
        public void run() {
            while (true) {
                Runnable runnable;
                synchronized (monitor) {
                    while (runnableLinkedList.isEmpty()) {
                        if (isShutdown) break;
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    runnable = runnableLinkedList.removeFirst();
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}
