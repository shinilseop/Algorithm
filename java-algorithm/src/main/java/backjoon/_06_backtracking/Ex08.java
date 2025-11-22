package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex08 {
    static int[][] stats;
    static int statGap;
    static int[][] Teams;

    public static void dfs(int idx, int startTeamIdx, int linkTeamIdx) {
//        System.out.println(idx+"============================");
//        System.out.println(Arrays.toString(Teams[0]));
//        System.out.println(Arrays.toString(Teams[1]));

        if (idx == stats.length) {
            int startStat = 0;
            for (int i = 0; i < Teams[0].length; i++) {
                for (int j = 0; j < Teams[0].length; j++) {
                    if (i != j) {
                        startStat+=stats[Teams[0][i]][Teams[0][j]];
                    }
                }
            }

            int linkStat = 0;
            for (int i = 0; i < Teams[1].length; i++) {
                for (int j = 0; j < Teams[1].length; j++) {
                    if (i != j) {
                        linkStat+=stats[Teams[1][i]][Teams[1][j]];
                    }
                }
            }

            statGap = Math.min(statGap, Math.abs(startStat - linkStat));
            return;
        }

        if (startTeamIdx < Teams[0].length) {
            Teams[0][startTeamIdx] = idx;
            dfs(idx + 1, startTeamIdx + 1, linkTeamIdx);
            Teams[0][startTeamIdx] = -1;
        }
        if (linkTeamIdx < Teams[1].length) {
            Teams[1][linkTeamIdx] = idx;
            dfs(idx + 1, startTeamIdx, linkTeamIdx + 1);
            Teams[1][linkTeamIdx] = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        stats = new int[size][size];
        statGap = Integer.MAX_VALUE;
        Teams = new int[2][size/2];
        Arrays.fill(Teams[0], -1);
        Arrays.fill(Teams[1], -1);
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(statGap);
    }
}
