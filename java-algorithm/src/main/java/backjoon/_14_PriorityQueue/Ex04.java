package backjoon._14_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04 {
    static int[] maxHeap, minHeap;
    static int maxLen, minLen;

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Maximum Heap
     */
    public static void insertMax(int num) {
        maxHeap[maxLen++] = num;

        int idx = maxLen - 1;
        while ((idx - 1) / 2 >= 0 && maxHeap[(idx - 1) / 2] < maxHeap[idx]) {
            swap(maxHeap, (idx - 1) / 2, idx);
            idx = (idx-1)/2;
        }
    }

    public static int removeMax() {
        int maxV = maxHeap[0];

        maxHeap[0] = maxHeap[--maxLen];
        int idx = 0;
        while (idx * 2 + 1 < maxLen) {
            int childIdx = idx*2+1;
            if (childIdx+1 < maxLen && maxHeap[childIdx] < maxHeap[childIdx+1]) {
                childIdx++;
            }

            if (maxHeap[idx] < maxHeap[childIdx]) {
                swap(maxHeap, idx, childIdx);
                idx = childIdx;
            } else {
                break;
            }
        }

        return maxV;
    }


    /**
     * Minimum Heap
     */
    public static void insertMin(int num) {
        minHeap[minLen++] = num;

        int idx = minLen - 1;
        while ((idx - 1) / 2 >= 0 && minHeap[(idx - 1) / 2] > minHeap[idx]) {
            swap(minHeap, (idx - 1) / 2, idx);
            idx = (idx-1)/2;
        }
    }

    public static int removeMin() {
        int minV = minHeap[0];

        minHeap[0] = minHeap[--minLen];
        int idx = 0;
        while (idx * 2 + 1 < minLen) {
            int childIdx = idx*2+1;
            if (childIdx+1 < minLen && minHeap[childIdx] > minHeap[childIdx+1]) {
                childIdx++;
            }

            if (minHeap[idx] > minHeap[childIdx]) {
                swap(minHeap, idx, childIdx);
                idx = childIdx;
            } else {
                break;
            }
        }

        return minV;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        maxHeap = new int[size];
        minHeap = new int[size];
        maxLen = minLen = 0;


        int mid = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(size * 2);
        sb.append(mid).append('\n');
        int len = 1;
        for (int i = 1; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            len++;

            if (len % 2 == 0) { // 짝수이므로 minHeap에 큰 값을 저장
                if (mid < num) {
                    insertMin(num);
                } else {
                    insertMin(mid);
//                    System.out.println("min : "+minLen+" && "+minHeap[0]+" > "+num);
                    if (maxLen > 0 && maxHeap[0] > num) {
                        mid = removeMax();
                        insertMax(num);
                    } else {
                        mid = num;
                    }
                }
            } else { // 홀수이므로 maxHeap에 작은 값을 저장
                if (mid > num) {
                    insertMax(num);
                } else {
                    insertMax(mid);
                    if (minLen > 0 && minHeap[0] < num) {
                        mid = removeMin();
                        insertMin(num);
                    } else {
                        mid = num;
                    }
                }
            }

            sb.append(mid).append('\n');
        }

        System.out.println(sb.toString());
    }
}
