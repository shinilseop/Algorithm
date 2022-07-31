package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        int idx,tmp;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            idx = i-1;
            while (idx >= 0 && arr[idx] > tmp) {
                arr[idx+1] = arr[idx];
                idx--;
            }
            arr[idx+1] = tmp;

//            System.out.print(i+" 회차 : ");
//            IntStream.range(0, arr.length).map(j -> arr[j]).forEach(System.out::print);
//            System.out.println();
        }
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

        insertionSort(arr);

        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::print);
        System.out.println();
    }
}
