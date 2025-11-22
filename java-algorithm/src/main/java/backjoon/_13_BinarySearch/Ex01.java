package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex01 {
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (target < arr[mid]) {
                hi = mid-1;
            } else if (target > arr[mid]) {
                lo = mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target, int from, int to) {
//        System.out.println(target+" == "+from+"~"+to);
        if (from == to) {
            if(arr[from] == target)
                return from;
            else
                return -1;
        } else if (to-from == 1) {
            if (arr[to] == target) {
                return to;
            } else if (arr[from] == target) {
                return from;
            } else {
                return -1;
            }
        }

        int mid = (from + to)/2;
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, to);
        } else if (arr[mid] == target) {
            return mid;
        } else {
            return binarySearch(arr, target, from, mid);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        StringBuilder sb = new StringBuilder(len2*2);
        for (int i = 0; i < arr2.length; i++) {
//            if (binarySearch(arr1, arr2[i], 0, arr1.length - 1) != -1) {
            if (binarySearch(arr1, arr2[i]) != -1) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.print(sb);
    }
}
