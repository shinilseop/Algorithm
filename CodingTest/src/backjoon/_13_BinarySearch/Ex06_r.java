package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06_r {
    static long N, k;

    public static long binarySearch(long min, long max) {
        long lo = min, hi = max;

        while (lo < hi) {
            long mid = (lo + hi) / 2;

            long cnt = countNum(mid);

            if (k <= cnt) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static long countNum(long value) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(value / i, N);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(1, N*N));
    }
}
