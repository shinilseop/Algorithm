package programmers.dev_match_first_half_2021;

import java.util.Arrays;

public class Ex02 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }

        int idx=0;
        int[] answer = new int[queries.length];

        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        for (int[] query : queries) {
            System.out.println("QUERY : "+Arrays.toString(query));
            int y1 = query[0]-1;
            int x1 = query[1]-1;
            int y2 = query[2]-1;
            int x2 = query[3]-1;

            int min = Integer.MAX_VALUE;
            int dir = 0;
            int tmp = matrix[y1][x1];
            int y = y1+dy[dir];
            int x = x1+dx[dir];
            while (y != y1 || x != x1) {
                min = Math.min(min, tmp);
                int tmpV = matrix[y][x];
                matrix[y][x] = tmp;

                int tmpY = y+dy[dir];
                int tmpX = x+dx[dir];
                if (tmpY < y1 || y2 < tmpY || tmpX < x1 || x2 < tmpX) {
                    dir++;
                    tmpY = y+dy[dir];
                    tmpX = x+dx[dir];
                }

                tmp = tmpV;
                y = tmpY;
                x = tmpX;
            }
            matrix[y][x] = tmp;

            answer[idx++] = min;

            System.out.println("MIN : "+min);
            System.out.println("=====RESULT=====");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
            System.out.println("================");
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();

        System.out.println(Arrays.toString(main.solution(6,10,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
    }
}
