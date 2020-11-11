package Week_04.homework;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/8 18:43
 * @Version 1.0
 */
public class JoinThreadMethod {
    public static int  result = 0;
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Runnable target = new Runnable() {
            @Override
            public void run() {
                result = sum();
            }
        };
        Thread thread = new Thread(target);
        thread.start();
        thread.join();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

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
}
