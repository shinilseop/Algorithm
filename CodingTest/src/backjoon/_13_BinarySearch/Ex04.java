package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];
        long hi = 0, lo = Integer.MAX_VALUE, max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            lo = Math.min(tree[i], lo);
            hi = Math.max(tree[i], hi);
        }

        int div = n % 2 == 0 ? m / 2 : m / 2 + 1;
        lo = lo-div<0?0:lo-div;
        long ans = 0;
//        System.out.println(lo+" "+hi);
        while (lo <= hi) {
            long mid = (hi + lo) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += tree[i] - mid > 0 ? tree[i] - mid : 0;
            }

//            System.out.println(lo+" "+mid+" "+hi+" = "+sum);

            if (sum >= m) {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
