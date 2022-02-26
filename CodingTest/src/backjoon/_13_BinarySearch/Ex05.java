package backjoon._13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] pos = new int[n];
        long max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, pos[i]);
            min = Math.min(min, pos[i]);
        }

        
    }
}
