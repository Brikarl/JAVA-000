package java0.conc0301.sync;

public class Cref {
    public static void main(String[] args) {
        int x = 10;
        int z = StaticFinal.A;
        int y = StaticFinal.B;
    }
}

class StaticFinal {
    public static final int A = 10;
    public static int B = 10;
}
