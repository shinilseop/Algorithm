package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {
    public static void merge(int arr[], int left, int right) {
        int[] L = Arrays.copyOfRange(arr, left, (left+right)/2);
        int[] R = Arrays.copyOfRange(arr,(left+right)/2, right);

        int i=0,j=0,idx=left;
//        for (int idx = left; idx < arr.length; idx++) {
//            if(i < L.length && j < R.length){
//                if (L[i] < R[j]) {
//                    arr[idx] = L[i++];
//                } else {
//                    arr[idx] = R[j++];
//                }
//            } else if(i < L.length) {
//                arr[idx] = L[i++];
//            } else if(j < R.length) {
//                arr[idx] = R[j++];
//            }
//        }

        // 더 빠름
        while (i < L.length && j < R.length) {
            if(L[i] < R[j]) {
                arr[idx++] = L[i++];
            } else {
                arr[idx++] = R[j++];
            }
        }

        while (i < L.length) {
            arr[idx++] = L[i++];
        }

        while (j < R.length) {
            arr[idx++] = R[j++];
        }
    }

    public static void divide(int arr[], int left, int right) {
        if (Math.abs(right-left) <= 1) {
            return;
        }

        divide(arr, left, (left + right) / 2);
        divide(arr, (left + right) / 2, right);
        merge(arr, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        int arr[] = new int[_loop];
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::print);
        System.out.println();
        System.out.println();

        divide(arr,0,arr.length);
        
        System.out.println("FINISH");
        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::println);
        System.out.println();
    }
}
