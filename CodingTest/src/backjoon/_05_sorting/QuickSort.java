package backjoon._05_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class QuickSort {
    public static int quickSort(int arr[], int left, int right) {
        int pivot = arr[left];
//        System.out.println();
//        System.out.print(left+" to "+right+" quicksort start pivot : ");
//        System.out.println(pivot);

        int i = left, j = right;
        while (i<j) {
            while (arr[j] > pivot) {
                j--;
            }

            while(i < j && arr[i] <= pivot) {
                i++;
            }

//            System.out.println(pivot+" : "+arr[i]+"("+i+"), "+arr[j]+"("+j+") Swap");
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

//        System.out.println("pivot and arr[" + i + "] chagne : " + pivot + "[" + left + "], " + arr[i] + "[" + i + "]");
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void partitioning(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIdx = quickSort(arr, left, right);
//        System.out.println("PIVOT IDX : "+pivotIdx);
//        System.out.print((loopCnt++)+"회전 결과("+left+"~"+right+") : ");
//        IntStream.range(0, arr.length).map(i->arr[i]).forEach(System.out::print);
//        System.out.println();

        partitioning(arr, left, pivotIdx-1);
        partitioning(arr, pivotIdx + 1, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());

        int arr[] = new int[_loop];
        for (int i = 0; i < _loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        partitioning(arr, 0, arr.length-1);
        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::print);
        System.out.println();
    }
}
