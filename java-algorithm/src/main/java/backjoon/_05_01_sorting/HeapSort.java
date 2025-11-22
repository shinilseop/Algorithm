package backjoon._05_01_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class HeapSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void buildHeap(int[] arr) {
        // MAX 빌드
        // arr.length/2 - 1 ==> 자식을 가진 노드 중 마지막 노드 (마지막 부모 노드)
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyMax(arr, arr.length, i);
//            heapifyMin(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapifyMax(arr, i, 0);
//            heapifyMin(arr, arr.length, i);
        }
    }

    public static void heapifyMax(int arr[], int length, int parentIdx) {
        int childIdx = parentIdx * 2 + 1;
        while (childIdx < length) {
            if (childIdx + 1 < length && arr[childIdx] < arr[childIdx + 1]) {
                childIdx++;
            }

            if (arr[parentIdx] < arr[childIdx]) {
                swap(arr, parentIdx, childIdx);
                parentIdx = childIdx;
                childIdx = parentIdx * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void heapifyMin(int arr[], int length, int parentIdx) {
        int childIdx = parentIdx * 2 + 1;
        while (childIdx < length) {
            if (childIdx + 1 < length && arr[childIdx] > arr[childIdx + 1]) {
                childIdx++;
            }

            if (arr[parentIdx] > arr[childIdx]) {
                swap(arr, parentIdx, childIdx);
                parentIdx = childIdx;
                childIdx = parentIdx * 2 + 1;
            } else {
                break;
            }
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
        System.out.println();

        buildHeap(arr);

        System.out.println("FINISH");
        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::print);
    }
}
