package Week_01.demo;

/**
 * 流程控制指令
 *
 * @Author: Yunkai Bo
 * @Date: 2020/10/17 12:54
 * @Version 1.0
 */
public class ForLoopTest {
    private static int[] numbers = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int i = 0; i < numbers.length; i++) {
            ma.submit(numbers[i]);
        }
        double avg = ma.getAvg();
    }
}
