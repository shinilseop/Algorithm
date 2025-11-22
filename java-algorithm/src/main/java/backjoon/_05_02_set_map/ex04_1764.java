package backjoon._05_02_set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex04_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(br.readLine());

        List<String> answer = new ArrayList<>();
        int cnt=0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                answer.add(input);
                cnt++;
            }
        }
        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (String ans : answer) {
            sb.append(ans).append('\n');
        }

        System.out.println(cnt);
        System.out.println(sb.toString().trim());
    }
}
