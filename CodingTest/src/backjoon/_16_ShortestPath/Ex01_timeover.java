package backjoon._16_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ex01_timeover {
    static Node[] nodes;
    static int[] minWeight;
    static int size;
    static StringBuffer answer;

    public static class Node {
        int num;
        HashMap<Integer, Integer> next;

        public Node(int num) {
            this.num = num;
            next = new HashMap<>();
        }

        public void addEdge(int idx, int weight) {
            next.put(idx, weight);
        }
    }

    public static void dfs(int start, int weightSum) {
        Node node = nodes[start];
        Iterator<Integer> iter = node.next.keySet().iterator();
        while (iter.hasNext()) {
            int key = iter.next();
            int weight = node.next.get(key);

            if (minWeight[key] > minWeight[start] + weight) {
                minWeight[key] = weightSum + weight;
                dfs(key, minWeight[key]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken());
        answer = new StringBuffer(size*5);
        nodes = new Node[size+1];
        minWeight=new int[size+1];
        for (int i = 0; i <= size; i++) {
            nodes[i] = new Node(i);
            minWeight[i] = Integer.MAX_VALUE;
        }
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].addEdge(to, weight);
        }

        minWeight[start] = 0;
        dfs(start, 0);

        for (int i = 1; i <= size; i++) {
            answer.append(minWeight[i] == Integer.MAX_VALUE ? "INF" : minWeight[i]).append('\n');
        }

        System.out.print(answer);
    }
}
