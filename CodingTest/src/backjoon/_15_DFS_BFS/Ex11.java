package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex11 {
    static StringBuffer answer;

    public static class Node {
        int num;
        boolean isRed;

        public Node(int num) {
            this.num = num;
        }
    }

    public static class Graph {
        int size;
        Node[] nodes;
        ArrayList<Integer>[] edges;
        boolean[] visited;

        public Graph(int size) {
            this.size = size;

            this.nodes = new Node[size+1];
            this.edges = new ArrayList[size+1];
            for (int i = 0; i <= size; i++) {
                this.nodes[i] = new Node(i);
                this.edges[i] = new ArrayList();
            }
            this.visited = new boolean[size+1];
        }

        public void addEdge(int start, int end) {
            edges[start].add(end);
            edges[end].add(start);
        }

        public boolean dfs(int start) {
            boolean result = true;

            for (int i = 0; i < edges[start].size(); i++) {
                if (!result) {
                    return result;
                }

                int next = edges[start].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    nodes[next].isRed = !nodes[start].isRed;
                    result = dfs(next);
                } else {
                    if (nodes[next].isRed == nodes[start].isRed) {
                        return false;
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        answer = new StringBuffer(T * 4);

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            Graph g = new Graph(size);

            int edges = Integer.parseInt(st.nextToken());
            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                g.addEdge(start, end);
            }

            for (int i = 1; i <= size; i++) {
                if (!g.visited[i]) {
                    g.visited[i] = true;
                    if (!g.dfs(i)) {
                        answer.append("NO\n");
                        break;
                    }
                }

                if (i == size) {
                    answer.append("YES\n");
                }
            }
        }
        System.out.print(answer);
    }
}
