package sw_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1228q {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());

            Queue<String> secret = new LinkedList<>();
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                secret.add(split[i]);
            }

            int order = Integer.parseInt(br.readLine());
            split = br.readLine().split(" ");
            int sIdx = 0;
            for (int i = 0; i < order; i++) {

                String cmd = split[sIdx++];
                int idx = Integer.parseInt(split[sIdx++]);
                int cmdCnt = Integer.parseInt(split[sIdx++]);

                Queue<String> tempQ = new LinkedList<>();
                for (int j = 0; j < idx; j++) {
                    tempQ.add(secret.poll());
                }

//                for()

            }
        }
    }
}
