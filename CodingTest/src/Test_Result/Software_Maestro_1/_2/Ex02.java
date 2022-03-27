package Test_Result.Software_Maestro_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex02 {
    static LinkedList<Integer>[] edges;
    static double[] satisfied;
    static boolean[] visited;
    static int cnt, remain;
    static ArrayList<Integer> noS;
    static int all;

    public static int dfs(int now) {
        int sum = 0;

        for (Integer next : edges[now]) {
            if (!visited[next]) {
                visited[next] = true;
                if (satisfied[next] == 0) {
                    remain++;
                } else {
                    cnt++;
                    sum += satisfied[next];
                }
                sum += dfs(next);
            }
        }

        return sum;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        satisfied = new double[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            double s = Double.parseDouble(st.nextToken());
            satisfied[p] = s;
        }

        edges = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) edges[i] = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
        }

        double sum = 0;
        all=0;
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                noS = new ArrayList<>();
                cnt = satisfied[i] == 0 ? 0 : 1;
                remain = satisfied[i] == 0 ? 1 : 0;
                visited[i] = true;
                double now = dfs(i) + satisfied[i];
                sum+=now;
                all+=cnt+remain;
                if (cnt == 0) {
                    all-=remain;
                } else {
                    System.out.println(now + " " + cnt + " " + remain);
                    for (int j = 0; j < remain; j++) {
                        sum += (int)(now / cnt);
                        System.out.println(sum);
                    }
                }
            }
        }

        System.out.println(sum+" "+all);
        System.out.printf("%.2f", sum/all);
    }
}
