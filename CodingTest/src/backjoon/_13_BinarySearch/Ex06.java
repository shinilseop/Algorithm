package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06 {
    static int n, k;

    public static int binarySearch() {
        int lo = 1, hi = n * n;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += mid / i;
            }

            if (k <= count) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        if ((int) Math.sqrt(k) == Math.sqrt(k)) {

        } else {

        }
    }
}
