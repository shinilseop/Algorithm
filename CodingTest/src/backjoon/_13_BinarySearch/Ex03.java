package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex03 {
    public static int binarySearch(int[] arr, long target) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

//            System.out.println(target+"=="+arr[mid]);
            if (target > arr[mid]) {
                lo = mid + 1;
            } else if (target < arr[mid]) {
                hi = mid - 1;
            } else {
                hi = mid - 1;
            }
        }
//        System.out.println(lo+" "+hi);

        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] size = new int[k];
        long hi = 0, lo = 0;
        for (int i = 0; i < k; i++) {
            size[i] = Integer.parseInt(br.readLine());
            hi += size[i];
            lo = Math.max(lo, size[i]);
        }

        hi /= n;
        lo = lo>n?lo/n:1;
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            int cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += size[i] / mid;
            }

            if (cnt >= n) {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            } else if (cnt < n) {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
