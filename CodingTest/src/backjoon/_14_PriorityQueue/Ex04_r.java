package backjoon._14_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Ex04_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer(size);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int mid = Integer.parseInt(br.readLine());
        answer.append(mid).append('\n');
        for (int i = 2; i <= size; i++) {
            int num = Integer.parseInt(br.readLine());

            /**
             * 1) 입력 개수가 짝수개 일때
             *  -   중간값의 위치가 len/2-1 이므로 MAX 라인이 더 많아야 함.
             *      따라서, 큰값을 minHeap 에 넣어야함.
             *
             * 2) 입력 개수가 홀수개 일때
             *  -   중간값의 위치가 len/2 이므로 MIN 라인이 MAX 라인과 개수가 같아져야 하기때문에
             *      따라서, 작은값을 maxHeap 에 넣어야함.
             */
            System.out.println(i + " " + mid + " " + num);
            if (i % 2 == 0) {
                if (mid >= num) {
                    minHeap.offer(mid);
                    mid = num;

//                    if (!maxHeap.isEmpty() && maxHeap.peek() > mid) {
//                        int tmp = maxHeap.poll();
//                        maxHeap.offer(mid);
//                        mid = tmp;
//                    }
                } else {
                    minHeap.offer(num);
                }
            } else {
                if (mid <= num) {
                    maxHeap.offer(mid);
                    mid = num;

                    if (!minHeap.isEmpty() && minHeap.peek() < mid) {
                        int tmp = minHeap.poll();
                        minHeap.offer(mid);
                        mid = tmp;
                    }
                } else {
                    maxHeap.offer(num);
                }
            }

            answer.append(mid).append('\n');
        }

        System.out.println(answer.toString());
    }
}
