package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Test {
    static boolean timeVisited[];

    public static class Time {
        int after;
        int pos;

        Time(int after, int pos) {
            this.after = after;
            this.pos = pos;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int obj = Integer.parseInt(st.nextToken());
        timeVisited = new boolean[obj+5];

        if(obj < start) {
            System.out.println(start - obj);
        } else {
            timeBFS(start, obj);
        }
    }

    static void timeBFS(int start, int obj) {
        LinkedList<Time> q = new LinkedList<>();
        q.offer(new Time(0, start));
        while (!q.isEmpty()) {
            Time t = q.poll();
            System.out.println(t.pos+" "+t.after);
            if (t.pos == obj) {
                System.out.println(t.after);
                break;
            } else {
                if (t.pos > 0 && !timeVisited[t.pos - 1]) {
                    timeVisited[t.pos - 1] = true;
                    q.offer(new Time(t.after + 1, t.pos - 1));
                }
                if (!timeVisited[t.pos + 1]) {
                    timeVisited[t.pos + 1] = true;
                    q.offer(new Time(t.after + 1, t.pos + 1));
                }
                if (t.pos * 2 <= obj+1 && !timeVisited[t.pos * 2]) {
                    timeVisited[t.pos * 2] = true;
                    q.offer(new Time(t.after + 1, t.pos * 2));
                }
            }
        }
    }
}
