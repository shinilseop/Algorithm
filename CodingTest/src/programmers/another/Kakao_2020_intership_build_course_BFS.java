package programmers.another;

import java.util.*;

public class Kakao_2020_intership_build_course_BFS {
    int n;
    public int solution(int[][] board) {
        int answer =Integer.MAX_VALUE;
         n = board.length;

        int[][][] dp = new int[4][n][n];

        for(int k=0; k<4; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dp[k][i][j] = Integer.MAX_VALUE;
                    System.out.println("dp"+k+" "+i+" "+j+" "+dp[k][i][j]);
                }
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0,0,-1,0));
        dp[0][0][0] = 0;
        while(!q.isEmpty()){
            Node cn = q.poll();

            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
            if(cn.x == n-1 && cn.y == n-1){
                answer = Math.min(answer, cn.cost);
                break;
//                continue;
            }

            for(int i=0; i<4; i++){
                int nx = cn.x + dx[i];
                int ny = cn.y + dy[i];
                if(nx>=0 && nx< n && ny>=0 && ny<n && board[nx][ny]==0){
                    int newCost;
                    if(cn.direction == i || cn.direction == -1){
                        newCost = cn.cost + 100;
                    }
                    else{
                        newCost = cn.cost + 600;
                    }

                    if(newCost <= dp[i][nx][ny]){
                        dp[i][nx][ny] = newCost;
                        q.offer(new Node(nx,ny,i,newCost));
                    }
                }
            }
        }

        return answer;
    }
    class Node implements Comparable<Node>{
        int x;
        int y;
        int direction;
        int cost;
        Node(int x, int y, int direction, int cost){
            this.x =x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}