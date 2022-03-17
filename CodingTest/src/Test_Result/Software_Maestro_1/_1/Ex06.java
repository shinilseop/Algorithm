package Test_Result.Software_Maestro_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex06 {
    // 가장 높은 값어치의 보물을 찾기
    // 1번에서 다시 1번으로 와야됨.
    // 원형의 순환구조 고려 못함..
    // 차라리 벨만 포드로 a to b 다 찾아 놓은 다음
    // 노드 하나씩 (확인 가치 - a to b - b to a)
    // 가장 큰값

    static int N, M;
    static LinkedList<Node>[] edges;
    static Node[] nodes;
    static int minIdx = Integer.MAX_VALUE, maxGet = -1;
    static boolean[] visited;

    public static class Node {
        int num, weight, get;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        public void setGet(int get) {
            this.get = get;
        }
    }

    public static void dfs(int start, int sum, int use) {
        if (sum - use * 2 > maxGet) {
            minIdx = start;
            maxGet = sum - (use * 2);
        } else if (sum - use * 2 == maxGet) {
            if (minIdx > start) {
                minIdx = start;
            }
        }

        for (int i = 0; i < edges[start].size(); i++) {
            Node next = edges[start].get(i);
            if (!visited[next.num]) {
                visited[next.num] = true;
                dfs(next.num, nodes[next.num].get, use + next.weight);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new Node[N + 1];
        edges = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            nodes[v] = new Node(v, w);
            nodes[u] = new Node(u, w);
            edges[u].add(nodes[v]);
            edges[v].add(nodes[u]);
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodes[x].setGet(v);
        }

        visited[1] = true;
        dfs(1, 0, 0);
        System.out.print(maxGet + " " + minIdx);
    }
}

//4 3
//1 2 3
//1 3 1
//3 4 3
//4 10
//2 7
//3 4