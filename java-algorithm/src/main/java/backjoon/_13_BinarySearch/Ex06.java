package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06 {
    static int n, k;

    public static long binarySearch() {
        long lo = 1, hi = k;

        while (lo < hi) {
            long mid = (lo + hi) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
//                System.out.println(i+":"+Math.min(mid / i, n));
                count += Math.min(mid / i, n);
            }

//            System.out.println(lo+" ~ "+hi+"=> mid:"+mid+", count:"+count);

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

        long ans = binarySearch();
        System.out.println(ans);
    }
}
