package programmers.high_scores._03_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex02_past {
    public class Solution {
        public int solution(int[][] jobs) {
            int delay = 0;
            int len = jobs.length;
            int time = 0;
            Queue<Task4> q = new PriorityQueue<>();
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

            int idx = 0;
            while (idx < len || !q.isEmpty()) {
                while (idx < len && jobs[idx][0] <= time) {
                    q.add(new Task4(jobs[idx][0], jobs[idx++][1]));
                }
                if (q.isEmpty()) {
                    time = jobs[idx][0];
                } else {
                    Task4 t = q.poll();
                    delay+=time-t.entry+t.time;
                    time+=t.time;
                }
            }

            return delay/len;
        }
    }

    class Task4 implements Comparable<Task4> {
        int entry;
        int time;

        Task4(int entry, int time) {
            this.entry = entry;
            this.time = time;
        }

        public int compareTo(Task4 t) {
            return (this.time - t.time);
        }
    }
}
