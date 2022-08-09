import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {
        int n = 5;
        int r = 3;

    }

    // n!/(n-r)!
    public static long p(int n, int r) {
        long sum = 1;
        for (int i = r + 1; i <= n; i++) {
            sum*=i;
        }
        return sum;
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1); // n*(n-1)!
    }
}
