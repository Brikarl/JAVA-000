import java.util.concurrent.Semaphore;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/11 10:29
 * @Version 1.0
 */
public class SemaphoreMethod {
    private Semaphore semaphore;
    private static volatile int result;


    public SemaphoreMethod() {
        semaphore = new Semaphore(1);
    }

    public void getValue() throws InterruptedException {
        semaphore.acquire();
        result = sum();
        semaphore.release();
    }

    public int printValue() throws InterruptedException {
        int res = 0;
        semaphore.acquire();
        res = result;
        semaphore.release();
        return res;
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

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        SemaphoreMethod method = new SemaphoreMethod();
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    method.getValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(target);
        thread.start();
        while (method.printValue() == 0) {
        }
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
