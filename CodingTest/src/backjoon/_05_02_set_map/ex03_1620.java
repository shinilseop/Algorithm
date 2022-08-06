package backjoon._05_02_set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ex03_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> strToInt = new HashMap<>();
        Map<Integer, String> intToStr = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            strToInt.put(input, i+1);
            intToStr.put(i+1, input);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if ('0' <= input.charAt(0) && input.charAt(0) <= '9') {
                sb.append(intToStr.get(Integer.parseInt(input))).append('\n');
            } else {
                sb.append(strToInt.get(input)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
