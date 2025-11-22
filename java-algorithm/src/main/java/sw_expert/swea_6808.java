package sw_expert;


import java.io.*;
import java.util.*;

// 순열 문제
// 완전 탐색 (발생할 수 있는 모든 경우의 수를 무식하게 탐색한다는 뜻)
// 브루트 포스 (탐색도중 특정조건을 만족하면 더 진행할지 안할지를 판단해서 진행해)

public class swea_6808 {
    static int N = 18, R = 9;
    static int[] gu;
    static int[] in;
    static int[] rem_card;
    static boolean[] isSelected;
    static int win;

    public static void game(int cnt) {
        if (cnt == R) {
            int gu_point = 0;
            int in_point = 0;
            for (int i = 0; i < R; i++) {
                if (gu[i] > in[i])
                    gu_point += (gu[i] + in[i]);
                else
                    in_point += (gu[i] + in[i]);
            }
            if (gu_point > in_point)
                win++;
            return;
        }
        for (int i = 0; i < R; i++) {
            if (isSelected[i])
                continue;
            in[cnt] = rem_card[i];
            isSelected[i] = true;
            game(cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <= tc; T++) {
            win = 0;
            gu = new int[9];
            in = new int[9];

            isSelected = new boolean[9];
            rem_card = new int[9];

            int idx = 0;
            boolean[] cnt = new boolean[18];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < R; i++) {
                gu[i] = Integer.parseInt(st.nextToken());
                cnt[gu[i] - 1] = true;
            }

            for (int i = 0; i < N; i++) {
                if (cnt[i])
                    continue;
                else
                    rem_card[idx++] = i + 1;
            }

            game(0);
            sb.append("#").append(T).append(" ").append(win).append(" ").append(362880 - win).append("\n");
        }
        System.out.println(sb.toString());
    }
}
