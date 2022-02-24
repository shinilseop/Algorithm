package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex04 {
    public static class Document implements Comparable<Document> {
        int prioirity;
        int idx;

        public Document(int prioirity, int idx) {
            this.prioirity = prioirity;
            this.idx = idx;
        }

        @Override
        public int compareTo(Document o) {
            return o.prioirity - this.prioirity;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb  = new StringBuffer(loop*2);

        while (loop-- > 0) {
            String[] input = (br.readLine()).split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            input = (br.readLine()).split(" ");
            Queue<Document> q = new LinkedList<>();
            Queue<Document> pq = new PriorityQueue<>();
            for (int i = 0; i < input.length; i++) {
                int prior = Integer.parseInt(input[i]);
                q.offer(new Document(prior, i));
                pq.offer(new Document(prior, i));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                if (pq.peek().prioirity == q.peek().prioirity) {
                    if (q.poll().idx == m) {
                        sb.append(cnt+1).append('\n');
                        break;
                    }
                    pq.poll();
                    cnt++;
                } else {
                    q.offer(q.poll());
                }
            }
        }
        System.out.print(sb.toString());
    }
}
