package backjoon._16_ShortestPath;

import java.io.*;
import java.util.*;

public class Ex04_BellmanFord {
    static long[] dist;
    static int N, M;
    static HashMap<Integer, Integer>[] edges;

    public static boolean bellmanFord(int start) {
        dist[start] = 0;

        for(int i=1;i<=N;i++){
            boolean isCycle = false;
            for(int j=1;j<=N;j++){
                int from = j;
                Iterator<Integer> iter = edges[j].keySet().iterator();
                while(iter.hasNext()){
                    int to = iter.next();
                    int weight = edges[j].get(to);
                    if(dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + weight) {
                        dist[to] = dist[from] + weight;
                        isCycle=true;
                    }
                }
            }

            if(isCycle && i==N){
                return false;
            } else if(!isCycle && i!=N){
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        edges = new HashMap[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new HashMap<>();
            dist[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(edges[from].containsKey(to)){
                edges[from].put(to, Math.min(edges[from].get(to), weight));
            } else {
                edges[from].put(to, weight);
            }
        }

        if(!bellmanFord(1)){
            System.out.println(-1);
        } else {
            StringBuffer sb=new StringBuffer();
            for(int i=2;i<=N;i++){
                if(dist[i]==Long.MAX_VALUE){
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }
            System.out.print(sb.toString().strip());
        }
    }
}
