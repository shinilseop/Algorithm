package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex02 {
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (target < arr[mid]) {
                hi = mid - 1;
            } else if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int countNum(int[] arr, int target) {
        int idx = binarySearch(arr, target);
        if (idx == -1)
            return 0;


        int cnt = 1;
        int lo = idx - 1, hi = idx + 1;
        while ((0 <= lo && arr[lo] == target) || (hi < arr.length && target == arr[hi])) {
            if (lo >= 0 && arr[lo] == target) {
                lo--;
                cnt++;
            } else if (hi < arr.length && arr[hi] == target) {
                hi++;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> count = new HashMap<>();
        int len1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[len1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int len2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[len2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder(len2 * 2);
        for (int i = 0; i < arr2.length; i++) {
            if (count.containsKey(arr2[i])) {
                sb.append(count.get(arr2[i])).append(' ');
            } else {
                int cnt = countNum(arr1, arr2[i]);
                count.put(arr2[i], cnt);
                sb.append(cnt).append(' ');
            }

        }
        System.out.print(sb);
    }
}
