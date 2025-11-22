package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex07 {

    public static int lowerBound(int[] arr, int maxIdx, int key) {
        int lo = 1, hi = maxIdx;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] numbers = new int[size+5];
        Arrays.fill(numbers, -1);
        int idx=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());

            if (numbers[idx] < value) {
                numbers[++idx] = value;
            } else {
                int upperIdx = lowerBound(numbers, idx, value);
                numbers[upperIdx] = value;
            }
        }

        System.out.println(idx);
    }
}
