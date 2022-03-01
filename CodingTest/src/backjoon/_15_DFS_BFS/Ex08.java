package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex08 {
    static int start, end;
    static boolean visited[];

    public static class Position {
        int pos, time;

        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void bfs() {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(start, 0));

        while (!q.isEmpty()) {
            Position p = q.poll();
//            System.out.println(p.pos);
            if (p.pos == end) {
                System.out.println(p.time);
                break;
            }

            if (!visited[p.pos + 1]) {
                visited[p.pos + 1] = true;
                q.offer(new Position(p.pos + 1, p.time + 1));
            }
            if (0 < p.pos && !visited[p.pos - 1]) {
                visited[p.pos - 1] = true;
                q.offer(new Position(p.pos - 1, p.time + 1));
            }
            if ((p.pos * 2 <= end*2) && !visited[p.pos * 2]) {
                visited[p.pos * 2] = true;
                q.offer(new Position(p.pos * 2, p.time + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = (br.readLine()).split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        visited = new boolean[end * 2];

        if (end < start) {
            System.out.println(start - end);
        } else {
            bfs();
        }
    }
}
