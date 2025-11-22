package programmers.high_scores._02_stack_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex02 {

    public static class Document implements Comparable<Document> {
        int idx;
        int priority;

        Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        public boolean equals(Document d) {
            return this.priority == d.priority;
        }

        @Override
        public int compareTo(Document document) {
            return -(this.priority - document.priority);
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Document> pq = new PriorityQueue<>();
        Queue<Document> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Document d = new Document(i, priorities[i]);
            pq.offer(d);
            q.offer(d);
        }

        int sequence = 0;
        boolean isPrint=false;
        while (!isPrint) {
            Document d = pq.poll();
            sequence++;
            while (!q.isEmpty()) {
                Document tmp = q.poll();

                System.out.println("tmp:"+tmp.idx+","+tmp.priority+", d:"+d.idx+","+d.priority);

                if (tmp.equals(d)) {
                    if (tmp.idx == location) {
                        answer = sequence;
                        isPrint = true;
                    }
                    break;
                } else {
                    q.offer(tmp);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Document d1 = new Document(1, 1);


        PriorityQueue<Document> pq = new PriorityQueue<>();
        Queue<Document> q = new LinkedList<>();

        pq.offer(d1);
        q.offer(d1);

        if (pq.peek() == q.peek()) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        int[] print = {1, 1, 9, 1, 1, 1};
        int location = 1;
        System.out.println(solution(print, location));


        print = new int[]{2, 1, 3, 2};
        location = 0;
        System.out.println(solution(print, location));
    }
}
