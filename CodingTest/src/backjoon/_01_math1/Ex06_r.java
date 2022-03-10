package backjoon._01_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] building = new int[15][15];
        for (int i = 1; i < building[1].length; i++) {
            building[0][i] = i;
        }

        for (int i = 1; i < building.length; i++) {
            building[i][1] = 1;
            for (int j = 2; j < building[i].length; j++) {
                building[i][j] = building[i][j - 1] + building[i - 1][j];
            }
        }

        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(building[k][n]).append('\n');
        }

        System.out.print(sb.toString().strip());
    }
}
