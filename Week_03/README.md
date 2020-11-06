# Week_03

## 10.29 Netty 原理与 API 网关

### 延迟时间与响应时间

- 响应时间：指的是网络IO的时间，比如发起一个请求，等待对方的返回消息的时间。针对调用者。
- 延迟时间：一般指的是系统内的时间，比如处理数据。针对系统。

## 10.31 Java 并发编程（1）

### Daemon 线程

有代码如下：

```java
public class DaemonThread {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread t = Thread.currentThread();
                System.out.println("当前线程:" + t.getName());
            }
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        thread.setDaemon(true);
        thread.start();
    }
}
```

由于存在设置`thread.setDaemon(true);`，所以 JVM 在发现线程执行中只有一个守护线程，就会结束运行，也就是说，该线程不会执行。

### 几个关键概念的区分

1. - Thread#start():创建新线程
   - Thread#run() : 本线程调用
2. - Thread.sleep: 释放 CPU
   - Object#wait : 释放锁