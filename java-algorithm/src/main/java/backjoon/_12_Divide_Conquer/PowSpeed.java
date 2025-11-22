package backjoon._12_Divide_Conquer;

public class PowSpeed {
    static int dcCnt = 0;
    static int powCnt = 0;

    public static long divideConquer(int base, int exp) {
        if (exp == 1) {
            dcCnt++;
            return base;
        }

        dcCnt++;
        long value = divideConquer(base, exp/2);

        if (exp % 2 == 1) {
            dcCnt++;
            return value*value*base;
        } else {
            dcCnt++;
            return value*value;
        }
    }

    public static long pow(int base, int exp) {
        long sum = 1;
        powCnt++;
        for (int i = 0; i < exp; i++) {
            sum*=base;
            powCnt++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 2100000;

        System.out.println("dcvalue : "+divideConquer(2, num));
        System.out.println("dcCnt : "+dcCnt);
        System.out.println("powvalue : "+pow(2, num));
        System.out.println("powCnt : "+powCnt);
    }
}
