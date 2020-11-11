import java.util.concurrent.*;


/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/8 18:58
 * @Version 1.0
 */
public class FutureTaskMethod implements Callable<Integer> {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask futureTask = new FutureTask(new FutureTaskMethod());
        executor.submit(futureTask);
        System.out.println(futureTask.get());

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + futureTask.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    @Override
    public Integer call() throws Exception {
        return sum();
    }
}
