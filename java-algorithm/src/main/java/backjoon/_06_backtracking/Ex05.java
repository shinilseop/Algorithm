package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex05 {
    static int cnt;
    static int n;
    static int[] queenIdx;

    public static void queenDFS(int queen) {
        if (queen == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queenIdx[queen] = i;
//            System.out.println(queen+"번째 : "+i);

            if (isPossible(queen)) {
                queenDFS(queen + 1);
            }
        }
    }

    public static boolean isPossible(int queen) {
        for (int y = 0; y < queen; y++) {
            // 같은 줄에 있는지 판단(가로)
            if (queenIdx[queen] == queenIdx[y]) {
//                System.out.println("같은 가로:"+queenIdx[queen]+" "+queenIdx[y]);
                return false;
            }

            // 열-열, 행-행 이 같다면 같은 대각선에 존재하는것.
            // abs 처리는 방향이 다르면 -가 되기 때문에
            int row = Math.abs(queenIdx[queen] - queenIdx[y]);
            int col = Math.abs(queen - y);
            if (row == col) {
//                System.out.println("같은 대각선:"+row+" "+col);
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = 0;

        queenIdx = new int[n];
        Arrays.fill(queenIdx, -1);

        queenDFS(0);

        System.out.println(cnt);
    }
}
