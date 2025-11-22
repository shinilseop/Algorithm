package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex11_r {
    static int[] group;
    static LinkedList<Integer>[] edges;
    static int V, E;

    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        group[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : edges[now]) {
                if (group[next] == 0) {
                    group[next] = group[now] == 2 ? 1 : 2;
                    q.offer(next);
                } else {
                    if (group[now] == group[next]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer(4 * T);
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edges = new LinkedList[V + 1];
            group = new int[V + 1];
            for (int i = 0; i <= V; i++) edges[i] = new LinkedList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                edges[from].add(to);
                edges[to].add(from);
            }

            boolean result = true;
            for (int i = 1; i <= V; i++) {
                if (group[i] == 0) {
                    result = bfs(i);
                }

                if(!result)
                    break;
            }

            if (result) {
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }
        }

        System.out.print(answer.toString().strip());
    }
}
