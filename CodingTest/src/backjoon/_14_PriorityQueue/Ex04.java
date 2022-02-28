package backjoon._14_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04 {
    static int[] heap;
    static int len;

    public static int insertOdd(int num) {
        heap[len++] = num;

        int idx = len-1;
        while (idx > 0 && heap[idx] > heap[(idx - 1) / 2]) {
            int tmp = heap[idx];
            heap[idx] = heap[(idx - 1) / 2];
            heap[(idx - 1) / 2] = tmp;

            idx = (idx - 1) / 2;
        }

        return heap[0];
    }

    public static int insertEven(int num) {
        heap[len++] = num;

        int idx = len-1;
        while (idx > 0 && heap[idx] < heap[(idx - 1) / 2]) {
            int tmp = heap[idx];
            heap[idx] = heap[(idx - 1) / 2];
            heap[(idx - 1) / 2] = tmp;

            idx = (idx - 1) / 2;
        }

        return heap[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        heap = new int[size];
        len = 0;

        StringBuffer sb = new StringBuffer(size * 2);
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());

            if ((len+1) % 2 == 0) {
                sb.append(insertEven(num)).append('\n');
            } else {
                sb.append(insertOdd(num)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
