package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex13 {
    private static class Line implements Comparable<Line> {
        int start, end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o1) {
            return this.start - o1.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Line[] lines = new Line[size+1];
        int[] dp = new int[size + 1];
        lines[0] = new Line(0, 0);
        for (int i = 1; i <= size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i]=new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            dp[i] = 1;
        }

        if (size == 1) {
            System.out.println(1);
        } else {
            Arrays.sort(lines);

            int max = 1;
            for (int i = 2; i <= size; i++) {
                for (int j = 1; j < i; j++) {
                    if (lines[i].end > lines[j].end && dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                }

                max = Math.max(max, dp[i]);
            }

            System.out.println(size - max);
        }
    }
}
