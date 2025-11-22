package programmers.high_scores._03_heap;

import java.util.PriorityQueue;

public class Ex01 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        int mixCnt = 0;
        while (!pq.isEmpty()) {
            int lowest = pq.poll();
            if (lowest >= K) {
                break;
            } else if(pq.size() == 0) {
                mixCnt=-1;
                break;
            } else {
                int secondLow = pq.poll();
                pq.offer(lowest + (secondLow * 2));
                mixCnt++;
            }
        }

        return mixCnt;
    }
}
