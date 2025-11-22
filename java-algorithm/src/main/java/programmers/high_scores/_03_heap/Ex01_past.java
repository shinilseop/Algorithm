package programmers.high_scores._03_heap;

import java.util.*;

public class Ex01_past {
    class Solution {
        public int solution(int[] scoville, int K) {
            int min = 0;

            PriorityQueue<Integer> sq = new PriorityQueue<>();
            for(int i=0;i<scoville.length;i++) {
                sq.add(scoville[i]);
            }

            while(!sq.isEmpty() && sq.size() >= 2 && sq.peek()<K) {
                int sum=sq.poll()+(sq.poll()*2);
                sq.add(sum);
                min++;
            }

            if(sq.peek()<K)
                return -1;

            return min;
        }
    }
}
