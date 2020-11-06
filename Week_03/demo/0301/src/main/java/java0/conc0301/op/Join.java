package java0.conc0301.op;

/**
 * 如果锁的都是同一个对象 oo ，那么在进行到第 20 个时，需要等待thread1 执行结束，但是thread1与main占有同一把锁，因此会卡死
 *
 */
public class Join {

    public static void main(String[] args) {
        Object oo = new Object();

        MyThread thread1 = new MyThread("thread1 -- ");
        thread1.setOo(oo);
        thread1.start();
//        synchronized (thread1) {
        synchronized (oo) {
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }
    }

}

class MyThread extends Thread {

    private String name;
    private Object oo;

    public void setOo(Object oo) {
        this.oo = oo;
    }

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        synchronized (this)
        synchronized (oo) {
            for (int i = 0; i < 100; i++) {
                System.out.println(name + i);
            }
        }
    }

}