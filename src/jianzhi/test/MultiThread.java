package jianzhi.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by liec on 2017-03-05.
 */
public class MultiThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Task[] tasks = new Task[]{
                new Task(0),
                new Task(1),
                new Task(2)
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> a = executorService.invokeAll(Arrays.asList(tasks));
        for (Future<String> s : a) {
            System.out.println("s.get() = " + s.get());
        }
    }

    static class Task implements Callable<String> {
        int a;

        public Task(int a) {
            this.a = a;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(new Random().nextInt(50));
            return "T:" + a;
        }
    }
}
