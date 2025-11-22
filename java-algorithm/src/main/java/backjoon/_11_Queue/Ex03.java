package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int cnt = 0;
        StringBuffer sb = new StringBuffer(n * 3 + 10);
        sb.append('<');
        while (!q.isEmpty()) {
            if (cnt == k-1) {
                sb.append(q.poll()).append(',').append(' ');
                cnt = 0;
            } else {
                q.offer(q.poll());
                cnt++;
            }
        }

        System.out.println(sb.substring(0, sb.toString().length()-2)+">");
    }
}
