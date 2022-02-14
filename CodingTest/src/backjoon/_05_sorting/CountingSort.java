package backjoon._05_sorting;

import java.io.*;

public class CountingSort {
    public static int[] countingSort(int arr[], int max) {
//        OptionalInt max = IntStream.range(0, arr.length).map(i -> arr[i]).max();
//        int[] countArr = new int[max.getAsInt()+1];
        int[] countArr = new int[max + 1];

        // Step 1. Make Counting Array
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        // Step 2. Counting Array Summing
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i-1];
        }

        // Step 3. Sorting
        int arr2[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[--countArr[arr[i]]] = arr[i];
        }

        return arr2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        int arr[] = new int[_loop];
        int max = 0;
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        arr = countingSort(arr, max);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]+"\n");
            }
        } catch (IOException e) {
        } finally {
            bw.close();
        }
    }
}
