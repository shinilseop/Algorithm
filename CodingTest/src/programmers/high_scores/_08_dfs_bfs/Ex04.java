package programmers.high_scores._08_dfs_bfs;

import java.util.*;

public class Ex04 {
    static boolean visited[][];
    static HashMap<String, Integer> nameToIdx;
    static LinkedList<String>[] edges;
    static String[] path;

    public static boolean move(String now, int idx) {
        if (idx == path.length) {
            return true;
        }

        int nowIdx = nameToIdx.get(now);

        for (int i = 0; i < edges[nowIdx].size(); i++) {
            if (!visited[nowIdx][i]) {
                visited[nowIdx][i]  = true;
                path[idx] = edges[nowIdx].get(i);
                if (move(path[idx], idx + 1)) {
                    return true;
                }
                visited[nowIdx][i]  = false;
            }
        }

        return false;
    }

    public static String[] solution(String[][] tickets) {
        nameToIdx = new HashMap<>();
        edges = new LinkedList[tickets.length+1];
        int idx = 0;
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String arrive = tickets[i][1];
            if (!nameToIdx.containsKey(start)) {
                edges[idx] = new LinkedList<>();
                nameToIdx.put(start, idx++);
            }
            if (!nameToIdx.containsKey(arrive)) {
                edges[idx] = new LinkedList<>();
                nameToIdx.put(arrive, idx++);
            }

            edges[nameToIdx.get(start)].add(arrive);
        }

        path = new String[tickets.length+1];
        visited = new boolean[edges.length][];
        for (int i = 0; i < edges.length; i++) {
            if(edges[i] != null) {
                Collections.sort(edges[i]);
                visited[i] = new boolean[edges[i].size()];
            }
        }

        path[0] = "ICN";
        move(path[0], 1);

        return path;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK" }, {"HND", "IAD" }, {"JFK", "HND" }};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets2)));
    }
}
