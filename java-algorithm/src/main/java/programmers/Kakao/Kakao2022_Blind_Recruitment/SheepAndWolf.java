package programmers.Kakao.Kakao2022_Blind_Recruitment;

import java.util.ArrayList;
import java.util.List;

public class SheepAndWolf {
    public static void main(String[] args) {

    }

    static class Node {
        boolean isSheep;
        List<Node> next;

        public Node(int isSheep) {
            if (isSheep == 0) {
                this.isSheep = true;
            } else {
                this.isSheep = false;
            }
            this.next = new ArrayList<>();
        }
    }

    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        Node[] nodes = new Node[info.length];
        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(info[i]);
        }

        for (int i = 0; i < edges.length; i++) {

        }

        return answer;
    }

    public static void bfs() {

    }
}
