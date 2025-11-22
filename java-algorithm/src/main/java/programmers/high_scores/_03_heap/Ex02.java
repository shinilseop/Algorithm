package programmers.high_scores._03_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex02 {
    public static class Task implements Comparable<Task> {
        int startTime, remainTime;

        Task(int startTime, int remainTime) {
            this.startTime = startTime;
            this.remainTime = remainTime;
        }

        @Override
        public int compareTo(Task task) {
            return this.remainTime - task.remainTime;
        }
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);

        int time = -1, next = 0, resposeTime = 0;
        PriorityQueue<Task> cpu = new PriorityQueue<>();
        boolean isWork = false;
        Task t = null;
        while (time <= jobs[jobs.length - 1][0] || !cpu.isEmpty() || t!=null) {
            time++;
            System.out.println("time:"+time);

            if (isWork) {
                t.remainTime--;
                System.out.println("working... " + t.startTime + " " + t.remainTime);
            } else {
                if (!cpu.isEmpty()) {
                    isWork = true;
                    t = cpu.poll();
                    t.remainTime--;
                    System.out.println("work start " + t.startTime + " " + t.remainTime);
                }
            }

            if (t != null && t.remainTime == 0) {
                resposeTime += time - t.startTime;
                System.out.println("response " + resposeTime);
                isWork=false;
                t = null;
            }

            while (next < jobs.length && jobs[next][0] == time) {
                System.out.println("Insert " + jobs[next][0] +" "+ jobs[next][1]);
                cpu.offer(new Task(jobs[next][0], jobs[next++][1]));
            }
        }

        return resposeTime / jobs.length;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 5}, {0, 3}, {1, 4}};
        int[][] jobs2 = {{0, 10}, {1, 5}};
        System.out.println(solution(jobs2));
    }
}
