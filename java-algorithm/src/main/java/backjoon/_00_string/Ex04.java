package backjoon._00_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int loop = Integer.parseInt(st.nextToken());
            char[] word = st.nextToken().toCharArray();

            for (int i = 0; i < word.length; i++) {
                for (int j = 0; j < loop; j++) {
                    sb.append(word[i]);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString().strip());
    }
}
