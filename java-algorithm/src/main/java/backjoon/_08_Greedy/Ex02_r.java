package backjoon._08_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex02_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] conf = new int[size][2];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            conf[i][0] = Integer.parseInt(st.nextToken());
            conf[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conf, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });

        int lastTime = conf[0][1], cnt = 1;
        for (int i = 1; i < conf.length; i++) {
            if (lastTime <= conf[i][0]) {
                lastTime = conf[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
