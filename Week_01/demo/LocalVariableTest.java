package Week_01.demo;

/**
 * 局部变量表调用
 *
 * @Author: Yunkai Bo
 * @Date: 2020/10/17 12:53
 * @Version 1.0
 */
public class LocalVariableTest {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        double avg = ma.getAvg();
    }
}
