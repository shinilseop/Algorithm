package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

    public static int lowerBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;

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

    public static int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
//        int[] arr = new int[size];
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < size; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        int key = Integer.parseInt(br.readLine());
//        int idx = lowerBound(arr, key);
//        System.out.println("idx:" + idx + ", value:" + arr[idx]);
//        idx = upperBound(arr, key);
//        System.out.println("idx:" + idx + ", value:" + arr[idx]);

//        int arr[] = {0, 1, 2, 3, 4, 4, 4, 6, 7};
        int arr[] = {-98127, 10, 10, 20, 20, 20};
        int key = 10;
        int idx = lowerBound(arr, key);
        System.out.println("idx:" + idx + ", value:" + arr[idx]);
        idx = upperBound(arr, key);
        System.out.println("idx:" + idx + ", value:" + arr[idx]);
    }
}
