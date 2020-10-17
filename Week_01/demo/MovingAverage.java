package Week_01.demo;

/**
 * 移动平均数
 *
 * @Author: Yunkai Bo
 * @Date: 2020/10/17 12:52
 * @Version 1.0
 */
public class MovingAverage {
    private int count = 0;
    private double sum = 0.0D;

    public void submit(double value) {
        this.count++;
        this.sum += value;
    }

    public double getAvg() {
        if (0 == this.count) {
            return sum;
        }
        return this.sum / this.count;
    }
}
