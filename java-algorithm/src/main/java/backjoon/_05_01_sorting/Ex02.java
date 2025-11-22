package backjoon._05_01_sorting;

import java.io.*;
import java.util.Arrays;

public class Ex02 {
    public static void merge(int arr[], int left, int right) {
        int[] L = Arrays.copyOfRange(arr, left, (left+right)/2);
        int[] R = Arrays.copyOfRange(arr,(left+right)/2, right);

        int i=0,j=0,idx=left;

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

//    public static void mergeSort(int[] array, int left, int right) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//
//            mergeSort(array, left, mid);
//            mergeSort(array, mid + 1, right);
//            merge(array, left, mid, right);
//        }
//    }
//
//    public static void merge(int[] array, int left, int mid, int right) {
//        int[] L = Arrays.copyOfRange(array, left, mid + 1);
//        int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
//
//        int i = 0, j = 0, k = left;
//        int ll = L.length, rl = R.length;
//
//        while (i < ll && j < rl) {
//            if (L[i] <= R[j]) {
//                array[k] = L[i++];
//            } else {
//                array[k] = R[j++];
//            }
//            k++;
//        }
//
//        while (i < ll) {
//            array[k++] = L[i++];
//        }
//
//        while (j < rl) {
//            array[k++] = R[j++];
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        int arr[] = new int[_loop];
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(arr,0,arr.length);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int n:arr){
            bw.write(n+"\n");
        }
        bw.close();
//        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(i-> {
//            try {
//                bw.write(arr[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
