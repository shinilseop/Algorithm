package backjoon._14_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01 {
    static int[] heap;
    static int len;

    public static void insertHeap(int num) {
        heap[len++] = num;
        int idx = len-1;
        while (idx > 0 && heap[(idx-1)/2] < heap[idx]) {
            int tmp = heap[(idx-1)/2];
            heap[(idx-1)/2] = heap[idx];
            heap[idx] = tmp;

            idx = (idx-1)/2;
        }
    }

    public static int deleteMax() {
        if (len == 0) {
            return 0;
        }

        int deleteItem = heap[0];

        heap[0] = heap[len-1];
        heap[len-1] = 0;
        len--;

        int idx = 0;
        while (idx*2+1 < len) {
            int childIdx = idx*2+1;
            if (childIdx + 1 < len && heap[childIdx] < heap[childIdx + 1]) {
                childIdx++;
            }

            if (heap[idx] < heap[childIdx]) {
                int tmp = heap[idx];
                heap[idx] = heap[childIdx];
                heap[childIdx] = tmp;
                idx = childIdx;
            } else {
                break;
            }
        }

        return deleteItem;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        heap = new int[size];
        len = 0;
        StringBuffer sb = new StringBuffer(size * 2);

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                sb.append(deleteMax()).append('\n');
            } else {
                insertHeap(num);
//                System.out.println(Arrays.toString(heap));
            }
        }

        System.out.println(sb);
    }
}
