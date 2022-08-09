package sw_expert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_6808_2 {
    public static List<Integer> enemy = new ArrayList<>(); // in -> 18 ->
    public static List<Integer> me = new ArrayList<>(); // gu
    public static boolean[] visit;
    public static int win = 0;
    public static int lose = 0;
    public static int MAXIMUM = 171 / 2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            visit = new boolean[9];
            win = lose = 0;
            me.clear();
            enemy.clear();

            for (int i = 1; i <= 18; i++) {
                enemy.add(i);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                me.add(Integer.parseInt(st.nextToken()));
                for (int j = 0; j < enemy.size(); j++) {
                    if (enemy.get(j) == me.get(i))
                        enemy.remove(j);
                }
            }

            permutation(0, 0, 0);

            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    public static void permutation(int m, int e, int d) {
//      if(d == 9) {
//          if(m > e) {
//              win += 1;
//          }
//          else if(m < e) {
//              lose += 1;
//          }
//
//          return;
//      }

        if (m > MAXIMUM || e > MAXIMUM) {
            int check = 1;
            for (int i = 9 - d; i > 0; i--) {
                check *= i;
            }
            if (m > e) {
                win += check;
            } else if (m < e) {
                lose += check;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (me.get(d) > enemy.get(i)) {
                    permutation(m + me.get(d) + enemy.get(i), e, d + 1);
                } else if (me.get(d) < enemy.get(i)) {
                    permutation(m, e + me.get(d) + enemy.get(i), d + 1);
                }
                visit[i] = false;
            }
        }
    }
}