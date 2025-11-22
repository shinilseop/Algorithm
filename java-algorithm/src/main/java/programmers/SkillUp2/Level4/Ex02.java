package programmers.SkillUp2.Level4;

import java.util.PriorityQueue;

public class Ex02 {
    public class Move implements Comparable<Move> {
        int from, to;
        int fromY, fromX;
        int toY, toX;

        public Move(int from, int fromY, int fromX, int to, int toY, int toX) {
            this.from = from;
            this.fromY = fromY;
            this.fromX = fromX;
            this.to = to;
            this.toY = toY;
            this.toX = toX;
        }

        @Override
        public int compareTo(Move move) {
            return Math.abs(from - to) - Math.abs(move.from - move.to);
        }
    }

    public int solution(int[][] land, int height) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        PriorityQueue<Move> pq = new PriorityQueue<>();

        boolean[][] visited = new boolean[land.length][land[0].length];
        visited[0][0]=true;
        pq.offer(new Move(land[0][0], 0, 0, land[1][0], 1, 0));
        pq.offer(new Move(land[0][0], 0, 0, land[0][1], 0, 1));
        while (!pq.isEmpty()) {
            Move m = pq.poll();

            if (visited[m.toY][m.toX]) {
                continue;
            }

            if(height < Math.abs(m.from-m.to)){
                answer+=Math.abs(m.from-m.to);
            }

            visited[m.toY][m.toX]=true;
            for (int k = 0; k < 4; k++) {
                int tmpX = m.toX+dx[k];
                int tmpY = m.toY+dy[k];

                if (0 <= tmpY && tmpY < land.length) {
                    if (0 <= tmpX && tmpX < land[0].length) {
                        pq.offer(new Move(land[m.toY][m.toX], m.toY, m.toX, land[tmpY][tmpX], tmpY, tmpX));
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height =3;
        System.out.println(main.solution(land, height));
    }
}
