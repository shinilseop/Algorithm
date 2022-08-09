package sw_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());

            LinkedList<String> secret = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                secret.add(st.nextToken());
            }

            int order = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < order; i++) {

                String cmd = st.nextToken();
                int idx = Integer.parseInt(st.nextToken());
                int cmdCnt = Integer.parseInt(st.nextToken());

                for (int j = 0; j < cmdCnt; j++) {
                    secret.add(idx++, st.nextToken());
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#"+t);
            for (int i = 0; i < 10; i++) {
                sb.append(' ').append(secret.get(i));
            }
            System.out.println(sb);
        }
    }
}
