package programmers.high_scores._04_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex01_past {
    public class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int ans[] = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int tmp[]=new int[commands[i][1]-commands[i][0]+1];
                int idx=0;
                for(int j=commands[i][0];j<=commands[i][1];j++) {
                    tmp[idx++]=array[j-1];
                }
                Arrays.sort(tmp);
                ans[i] = tmp[commands[i][2]-1];
            }

            return ans;
        }
    }
}
